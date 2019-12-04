package com.pacman29.testsber.controller;

import com.pacman29.testsber.model.Counter;
import com.pacman29.testsber.model.CounterValue;
import com.pacman29.testsber.model.Summary;
import com.pacman29.testsber.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/counters")
public class CounterController {

    private final CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping
    public List<Counter> getCounters() {
        return counterService.getCounters();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Counter createCounter(@Valid @RequestBody Counter newCounter) {
        return counterService.createCounter(newCounter);
    }

    @GetMapping(value = "{counterName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Counter getCounterByName(@PathVariable String counterName) {
        return counterService.getCounterByName(counterName);
    }

    @PutMapping(value = "{counterName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Counter updateCounter(
            @PathVariable String counterName,
            @Valid @RequestBody CounterValue newCounterParams) {
        return counterService.updateCounter(counterName, newCounterParams);
    }

    @DeleteMapping("{counterName}")
    public Counter deleteCounter(@PathVariable String counterName) {
        return counterService.deleteCounter(counterName);
    }

    @GetMapping("/summary")
    public Summary getSum() {
        return counterService.getSummary();
    }

}
