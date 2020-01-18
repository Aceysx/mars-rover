package com.thoughtworks.marsrover.model;

public enum Direction {
    N, E, S, W;

    public Direction next() {
        Direction[] values = Direction.values();
        int ordinal = this.ordinal() + 1;
        if (ordinal > values.length - 1) {
            return values[0];
        }
        return values[ordinal];
    }

    public Direction prev() {
        Direction[] values = Direction.values();
        int ordinal = this.ordinal() - 1;
        if (ordinal < 0) {
            return values[values.length - 1];
        }
        return values[ordinal];
    }

    public String reverse() {
        Direction[] values = Direction.values();
        int ordinal = this.ordinal() - values.length / 2;
        return ordinal < 0 ? values[this.ordinal() + values.length / 2].toString() : values[ordinal].toString();
    }
}
