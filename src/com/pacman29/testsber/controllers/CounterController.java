package com.pacman29.testsber.controllers;

import com.pacman29.testsber.exceptions.CounterAlreadyExistsException;
import com.pacman29.testsber.exceptions.CounterNotFoundException;
import com.pacman29.testsber.models.Counter;
import com.pacman29.testsber.models.CounterValue;
import com.pacman29.testsber.models.Summary;
import com.pacman29.testsber.services.ICounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/counters")
public class CounterController {

    private final ICounterService counterService;

    @Autowired
    public CounterController(ICounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping
    public ArrayList<Counter> getCounters(){
        return counterService.getCounters();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCounter(@Valid @RequestBody Counter newCounter) throws CounterAlreadyExistsException {
        counterService.createCounter(newCounter);
    }

    @GetMapping("{counterName}")
    public Counter getCounterByName(@PathVariable @NotNull String counterName) throws CounterNotFoundException {
        return counterService.getCounterByName(counterName);
    }

    @PutMapping("{counterName}")
    public void updateCounter(
            @PathVariable @NotNull String counterName,
            @Valid @RequestBody CounterValue newCounterParams)
            throws CounterNotFoundException{
        counterService.updateCounter(counterName, newCounterParams);
    }

    @DeleteMapping("{counterName}")
    public void deleteCounter(@PathVariable @NotNull String counterName) throws CounterNotFoundException{
        counterService.deleteCounter(counterName);
    }

    @GetMapping("/summary")
    public Summary getSum(){
        return new Summary(counterService.getSummary());
    }

}
