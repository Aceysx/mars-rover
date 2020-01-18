package com.thoughtworks.marsrover.model.vo;

import com.thoughtworks.marsrover.model.Direction;

public class Location implements ValueObject{
    private Position position;
    private Direction direction;
    private boolean isBackward;

    public Location(int x, int y, String direction, boolean isBackward) {
        this.position = Position.build(x, y);
        this.direction = Direction.valueOf(direction);
        this.isBackward = isBackward;
    }

    public static Location build(int x, int y, String direction) {
        return new Location(x, y, direction, false);
    }

    public static Location build(int x, int y, String direction, boolean isBackward) {
        return new Location(x, y, direction, isBackward);
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public Location reverse() {
        return Location.build(
            this.position.getX(),
            this.position.getY(),
            this.direction.reverse(),
            !this.isBackward
        );
    }

    public boolean isBackward() {
        return this.isBackward;
    }
}
