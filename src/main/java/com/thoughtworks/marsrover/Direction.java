package com.thoughtworks.marsrover;

import java.util.Arrays;
import java.util.List;

public class Direction {
    private final List<String> DIRECTIONS = Arrays.asList(
        "N", "E", "S", "W"
    );
    private String value;

    public Direction(String direction) {
        this.value = direction;
    }

    public static Direction build(String direction) {
        return new Direction(direction);
    }

    public Direction next(String turnTo) {
        int currentIndex = DIRECTIONS.indexOf(this.getValue());
        if ("L".equals(turnTo)) {
            int next = currentIndex - 1;
            return Direction.build(next < 0
                ? DIRECTIONS.get(DIRECTIONS.size() - 1)
                : DIRECTIONS.get(next));
        }
        if ("R".equals(turnTo)) {
            int next = currentIndex + 1;
            return Direction.build(next > DIRECTIONS.size()
                ? DIRECTIONS.get(0)
                : DIRECTIONS.get(next));
        }
        throw new RuntimeException("cmd is error");
    }

    public String getValue() {
        return this.value;
    }
}
