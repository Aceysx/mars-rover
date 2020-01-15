package com.thoughtworks.marsrover;

public class TurnLeftCommand implements Command {
    @Override
    public Location execute(Location location) {
        Direction direction = location.getDirection();
        Position position = location.getPosition();

        return Location.build(
            position.getX(),
            position.getY(),
            String.valueOf(direction.prev()));
    }
}
