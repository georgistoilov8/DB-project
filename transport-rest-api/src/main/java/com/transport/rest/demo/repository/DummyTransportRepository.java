package com.transport.rest.demo.repository;

import com.transport.rest.demo.model.*;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class DummyTransportRepository implements TransportRepository {

    @Override
    public List<Vehicle> getAllVehicles() {
        return Arrays.asList(new Vehicle("audi", "a5", "aaaaa", 5, 4, true, false, "car", 0));
    }

    @Override
    public List<Line> getLinesGroupedByType() {
        return Arrays.asList(new Line(3, 3, 3, 4), new Line(2, 2, 2, 2));
    }

    @Override
    public List<Stop> getStopsByLine(int lineId) {
        return Arrays.asList(new Stop(1, "address1", 1, 2, true), new Stop(2, "address2", 2, 3, false));
    }

    @Override
    public List<Schedule> getSchedulesByLineAndStops(int lineId, List<Integer> stopIds) {
        return Arrays.asList(new Schedule(1, 1, 1, "t1", new Date(), Arrays.asList(new ArrivalTime(12,30), new ArrivalTime(14, 0))));
    }

    @Override
    public List<Passenger> getPassengersWithCardLine() {
        return Arrays.asList(new Passenger("ivo", "traiharda"), new Passenger("ivo", "socialniq"), new Passenger("ivo", "autista"));
    }
}
