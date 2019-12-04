package com.pacman29.testsber.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

@Data
@Accessors(chain = true)
public class Counter extends CounterValue {
    @NotEmpty(message = "{validation.provide_name}")
    private String name;

    public Counter(@NotEmpty(message = "{validation.provide_name}") String name, Integer value) {
        super(value);
        this.name = name;
    }
}
