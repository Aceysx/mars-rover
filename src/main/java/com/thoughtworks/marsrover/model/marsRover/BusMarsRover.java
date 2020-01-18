package com.thoughtworks.marsrover.model.marsRover;

import com.thoughtworks.marsrover.model.vo.Location;
import com.thoughtworks.marsrover.model.vo.Radar;

public class BusMarsRover extends MarsRover {

    public BusMarsRover(int x, int y, String direction, Radar radar) {
        super(x, y, direction, radar);
    }

    @Override
    boolean hasTraps(String cmd, Location next) {
        return this.radar.isMarkedTrap(next.getPosition());
    }

}
