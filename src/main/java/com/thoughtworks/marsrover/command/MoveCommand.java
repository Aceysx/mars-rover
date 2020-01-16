package com.thoughtworks.marsrover.command;

import com.thoughtworks.marsrover.Direction;
import com.thoughtworks.marsrover.Location;
import com.thoughtworks.marsrover.Position;

public class MoveCommand implements Command {
    @Override
    public Location execute(Location location) {
        Position position = location.getPosition();
        String direction = location.getDirection().toString();

        if (Direction.N.toString().equals(direction)) {
            return Location.build(position.getX(), position.getY() + 1, direction, location.isBackward());
        }
        if (Direction.W.toString().equals(direction)) {
            return Location.build(position.getX() - 1, position.getY(), direction, location.isBackward());
        }
        if (Direction.S.toString().equals(direction)) {
            return Location.build(position.getX(), position.getY() - 1, direction, location.isBackward());
        }
        if (Direction.E.toString().equals(direction)) {
            return Location.build(position.getX() + 1, position.getY(), direction, location.isBackward());
        }
        throw new RuntimeException("cmd is error");
    }
}
