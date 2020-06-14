package com.transport.rest.demo.repository;

import com.transport.rest.demo.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

@Repository
public class JdbcTransportRepository implements TransportRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcTransportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return jdbcTemplate.query("SELECT brand, model, numberPlate, seatCapacity, standingCapacity, airConditioner," +
                        " wheelchairRamp, name AS type, lineID FROM FN45465.Vehicle JOIN FN45465.Vehicle_Type ON vehicleTypeID = ID",
                (rs, rowNum) -> new Vehicle(
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("numberPlate"),
                        rs.getInt("seatCapacity"),
                        rs.getInt("standingCapacity"),
                        rs.getInt("airConditioner") == 1,
                        rs.getInt("wheelchairRamp") == 1,
                        rs.getString("type"),
                        rs.getInt("lineID")
                ));
    }

    @Override
    public List<Line> getLinesGroupedByType() {
        return jdbcTemplate.query("SELECT L.ID, L.number, L.stopsCount, L.distance, VT.name as type FROM FN45465.Line L " +
                        "JOIN FN45465.Vehicle V ON L.ID = V.lineID " +
                        "JOIN FN45465.Vehicle_Type VT ON V.vehicleTypeID = VT.ID ORDER BY VT.name",
                (rs, rowNum) -> new Line(
                        rs.getInt("ID"),
                        rs.getInt("number"),
                        rs.getInt("stopsCount"),
                        rs.getDouble("distance"),
                        rs.getString("type")
                ));
    }

    @Override
    public List<Stop> getStopsByLine(int lineId) {
        return jdbcTemplate.query("SELECT S.ID, S.address, S.longitude, S.latitude, S.chargeCard FROM FN45465.Stop S " +
                        "JOIN FN45465.Consist_Of C ON S.ID = C.stopID " +
                        "JOIN FN45465.Line L ON L.ID = C.lineID " +
                        "WHERE C.lineID = ?",
                new Object[]{lineId},
                (rs, rowNum) -> new Stop(
                        rs.getInt("ID"),
                        rs.getString("address"),
                        rs.getDouble("longitude"),
                        rs.getDouble("latitude"),
                        rs.getInt("chargeCard") == 1
                ));
    }

    private List<ArrivalTime> getArrivalTimesForSchedule(int scheduleId) {
        return jdbcTemplate.query("SELECT AT.time " +
                        "FROM FN45465.Arrival_Type AT " +
                        "JOIN FN45465.Provides P ON AT.ID = P.arrivalTimeID" +
                        " WHERE P.scheduleID = ?",
                new Object[] {scheduleId},
                (rs, rowNum) -> {
                    LocalTime lt = rs.getTime("time").toLocalTime();
                    return new ArrivalTime(lt.getHour(), lt.getMinute());
                });
    }

    @Override
    public List<Schedule> getSchedulesByLineAndStops(int lineId, List<Integer> stopIds) {
        final String query = "SELECT SC.ID, SC.lineID, SC.stopID, SCT.season, SCT.dayType, SC.currentDate AS date " +
                "FROM FN45465.Line L " +
                "JOIN FN45465.Consist_Of CO ON L.ID = ? AND CO.stopID IN (%s) AND L.ID = CO.lineID " +
                "JOIN FN45465.Stop ST ON ST.ID = CO.stopID " +
                "JOIN FN45465.Schedule SC ON SC.lineID = L.ID AND SC.stopID = ST.ID " +
                "JOIN FN45465.Schedule_Type SCT ON SCT.ID = SC.scheduleTypeID ";
        final String inSql = String.join(",", Collections.nCopies(stopIds.size(), "?"));
        final String queryWithStopIds = String.format(query, inSql);

        stopIds.add(0, lineId);
        List<Schedule> schedules = jdbcTemplate.query(queryWithStopIds, stopIds.toArray(),
                (rs, rowNum) -> {
                    Schedule s = new Schedule();
                    s.setId(rs.getInt("ID"));
                    s.setLineId(rs.getInt("lineID"));
                    s.setStopId(rs.getInt("stopID"));
                    s.setSeason(rs.getString("season"));
                    s.setDayType(rs.getString("dayType"));
                    s.setDate(rs.getDate("date"));
                    return s;
                });

        schedules.forEach(schedule -> schedule.setTimeList(getArrivalTimesForSchedule(schedule.getId())));

        return schedules;
    }

    @Override
    public List<Passenger> getPassengersWithCardLine() {
        return jdbcTemplate.query("SELECT P.firstName, P.lastName FROM FN45465.Passenger P " +
                        "JOIN FN45465.Card_Line CL ON P.EGN = CL.passengerEGN",
                (rs, rowNum) -> new Passenger(rs.getString("firstName"), rs.getString("lastName")));
    }
}
