package com.thoughtworks.marsrover;

import com.thoughtworks.marsrover.command.Command;

public class MarsRover {
    private Location location;

    public MarsRover(int x, int y, String direction) {
        this.location = Location.build(x, y, direction);
    }

    public MarsRover execute(String cmd) {
        Command command = Command.build(cmd);
        this.updateLocation(command.execute(location));
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
}
