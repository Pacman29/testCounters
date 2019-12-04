package com.pacman29.testsber.exceptions;

public class CounterAlreadyExistsException extends RuntimeException {
    public CounterAlreadyExistsException(String counterName) {
        super(String.format("Counter with name: %s already exists", counterName));
    }
}