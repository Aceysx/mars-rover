package com.thoughtworks.marsrover;

public class MoveCommand implements Command {
    @Override
    public Location execute(Location location) {
        Position position = location.getPosition();
        String direction = location.getDirection().toString();

        if (Direction.N.toString().equals(direction)) {
            return Location.build(position.getX(), position.getY() + 1, direction);
        }
        if (Direction.W.toString().equals(direction)) {
            return Location.build(position.getX() - 1, position.getY(), direction);
        }
        if (Direction.S.toString().equals(direction)) {
            return Location.build(position.getX(), position.getY() - 1, direction);
        }
        if (Direction.E.toString().equals(direction)) {
            return Location.build(position.getX() + 1, position.getY(), direction);
        }
        throw new RuntimeException("cmd is error");
    }
}
