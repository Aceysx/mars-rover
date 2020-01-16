package com.thoughtworks.marsrover.command;

import com.thoughtworks.marsrover.Direction;
import com.thoughtworks.marsrover.Location;
import com.thoughtworks.marsrover.Position;

public class TurnLeftCommand implements Command {
    @Override
    public Location execute(Location location) {
        Direction direction = location.getDirection();
        Position position = location.getPosition();

        return Location.build(
            position.getX(),
            position.getY(),
            String.valueOf(direction.prev()),
            location.isBackward());
    }
}
