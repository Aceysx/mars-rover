package com.thoughtworks.marsrover;

public class MarsRover {
    private Position position;
    private String direction;

    public MarsRover(int x, int y, String direction) {
        this.position = Position.build(x, y);
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public String getDirection() {
        return direction;
    }
}
