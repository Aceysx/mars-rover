package com.thoughtworks.marsrover;

public enum Direction {
    N, E, S, W;

    Direction next() {
        Direction[] values = Direction.values();
        int ordinal = this.ordinal() + 1;
        if (ordinal > values.length - 1) {
            return values[0];
        }
        return values[ordinal];
    }

    Direction prev() {
        Direction[] values = Direction.values();
        int ordinal = this.ordinal() - +1;
        if (ordinal < 0) {
            return values[values.length - 1];
        }
        return values[ordinal];
    }

}
