package com.pacman29.testsber.models;

import javax.validation.constraints.NotEmpty;

public class Counter extends CounterValue {
    @NotEmpty(message = "Please provide a name")
    private String name;

    public Counter(@NotEmpty(message = "Please provide a name") String name, Integer value) {
        super(value);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
