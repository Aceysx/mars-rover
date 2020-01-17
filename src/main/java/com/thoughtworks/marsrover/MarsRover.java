package com.thoughtworks.marsrover;

import com.thoughtworks.marsrover.command.Command;
import com.thoughtworks.marsrover.model.Radar;

public class MarsRover {
    private Location location;
    private Radar radar;

    public MarsRover(int x, int y, String direction) {
        this.location = Location.build(x, y, direction);
        this.radar = new Radar();
    }

    public MarsRover(int x, int y, String direction, Radar radar) {
        this.location = Location.build(x, y, direction);
        this.radar = radar;
    }

    public MarsRover execute(String cmd) {
        Command command = Command.build(cmd);
        Location next = command.execute(location);
        if (this.radar.isMarkedTrap(next.getPosition())) {
            return this;
        }
        this.updateLocation(next);
        return this;
    }


    public Position getPosition() {
        return location.getPosition();
    }

    public String getDirection() {
        return location.getDirection().toString();
    }

    private void updateLocation(Location location) {
        this.location = location;
    }

    public boolean isBackward() {
        return this.location.isBackward();
    }

    public boolean inTrap() {
        return radar.inTrap(this.location.getPosition());
    }
}
