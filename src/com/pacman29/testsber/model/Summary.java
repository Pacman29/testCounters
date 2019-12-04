package com.pacman29.testsber.model;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Summary {
    private Integer result = 0;
}
