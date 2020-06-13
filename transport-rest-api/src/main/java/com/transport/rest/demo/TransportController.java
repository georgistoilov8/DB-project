package com.transport.rest.demo;

import com.transport.rest.demo.model.*;
import com.transport.rest.demo.repository.TransportRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/")
public class TransportController {
    private TransportRepository repository;

    TransportController(TransportRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/vehicle")
    List<Vehicle> getAllVehicles() {
        return repository.getAllVehicles();
    }

    @GetMapping("/line")
    List<Line> getLinesGroupedByType() {
        return repository.getLinesGroupedByType();
    }

    @GetMapping("/stop/{lineId}")
    List<Stop> getStopsByLine(@PathVariable int lineId) {
        return repository.getStopsByLine(lineId);
    }

    @GetMapping("/schedule/{lineId}")
    List<Schedule> getSchedulesByLineAndStops(@PathVariable int lineId, ArrayList<Integer> stopIds) {
        return repository.getSchedulesByLineAndStops(lineId, stopIds);
    }

    @GetMapping("/passenger")
    List<Passenger> getPassengersWithCardLine() {
        return repository.getPassengersWithCardLine();
    }
}
