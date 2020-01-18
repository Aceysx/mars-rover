package com.thoughtworks.marsrover.model;

import com.thoughtworks.marsrover.model.vo.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<Position> right(Position position) {
        if (this.equals(Direction.N)) {
            return Arrays.asList(Position.build(position.getX() + 1, position.getY()),
                Position.build(position.getX() + 1, position.getY() - 1));
        }
        if (this.equals(Direction.W)) {
            return Arrays.asList(Position.build(position.getX(), position.getY() + 1),
                Position.build(position.getX() + 1, position.getY() + 1));
        }
        if (this.equals(Direction.S)) {
            return Arrays.asList(Position.build(position.getX() - 1, position.getY()),
                Position.build(position.getX() - 1, position.getY() + 1));
        }
        if (this.equals(Direction.E)) {
            return Arrays.asList(Position.build(position.getX(), position.getY() - 1),
                Position.build(position.getX() - 1, position.getY() - 1));
        }
        return new ArrayList<>();
    }

    public List<Position> left(Position position) {
        if (this.equals(Direction.N)) {
            return Arrays.asList(Position.build(position.getX() - 1, position.getY()),
                Position.build(position.getX() - 1, position.getY() - 1));
        }
        if (this.equals(Direction.W)) {
            return Arrays.asList(Position.build(position.getX(), position.getY() - 1),
                Position.build(position.getX() + 1, position.getY() - 1));
        }
        if (this.equals(Direction.S)) {
            return Arrays.asList(Position.build(position.getX() + 1, position.getY()),
                Position.build(position.getX() + 1, position.getY() + 1));
        }
        if (this.equals(Direction.E)) {
            return Arrays.asList(Position.build(position.getX(), position.getY() + 1),
                Position.build(position.getX() - 1, position.getY() + 1));
        }
        return new ArrayList<>();
    }
}
