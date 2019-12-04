package com.pacman29.testsber.service;

import com.pacman29.testsber.exception.CounterAlreadyExistsException;
import com.pacman29.testsber.exception.CounterNotFoundException;
import com.pacman29.testsber.model.Counter;
import com.pacman29.testsber.model.CounterValue;
import com.pacman29.testsber.model.Summary;

import java.util.List;

public interface CounterService {
    Summary getSummary();

    Counter getCounterByName(String name) throws CounterNotFoundException;

    List<Counter> getCounters();

    Counter createCounter(Counter counter) throws CounterAlreadyExistsException;

    Counter updateCounter(String counterName, CounterValue counter) throws CounterNotFoundException;

    Counter deleteCounter(String counterName) throws CounterNotFoundException;
}
