package com.thoughtworks.marsrover;

public class Location {
    private Position position;
    private Direction direction;

    public Location(int x, int y, String direction) {
        this.position = Position.build(x, y);
        this.direction = Direction.valueOf(direction);
    }

    public static Location build(int x, int y, String direction) {
        return new Location(x, y, direction);
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}
