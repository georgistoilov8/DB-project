package com.transport.rest.demo.repository;

import com.transport.rest.demo.model.*;

import java.util.List;

public interface TransportRepository {
    List<Vehicle> getAllVehicles();

    List<Line> getLinesGroupedByType();

    List<Stop> getStopsByLine(int lineId);

    List<Schedule> getSchedulesByLineAndStops(int lineId, List<Integer> stopIds);

    List<Passenger> getPassengersWithCardLine();
}
