package com.thoughtworks.marsrover.model.marsRover;

import com.thoughtworks.marsrover.model.Instruction;
import com.thoughtworks.marsrover.model.vo.Location;
import com.thoughtworks.marsrover.model.vo.Radar;

public class DefaultMarsRover extends MarsRover {

    public DefaultMarsRover(int x, int y, String direction) {
        super(x, y, direction);
    }

    public DefaultMarsRover(int x, int y, String direction, Radar radar) {
        super(x, y, direction, radar);
    }

    @Override
    boolean hasTraps(Instruction instruction, Location next) {
        if (Instruction.L.equals(instruction)) {
            return next.getDirection().right(next.getPosition())
                .stream()
                .anyMatch(item -> this.radar.isMarkedTrap(item));
        }
        if (Instruction.R.equals(instruction)) {
            return next.getDirection().left(next.getPosition())
                .stream()
                .anyMatch(item -> this.radar.isMarkedTrap(item));
        }
        return this.radar.isMarkedTrap(next.getPosition());
    }

}
