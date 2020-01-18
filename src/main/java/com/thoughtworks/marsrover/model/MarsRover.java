package com.thoughtworks.marsrover.model;

import com.thoughtworks.marsrover.command.Command;

import java.util.ArrayList;
import java.util.List;

public class MarsRover {
    private Location location;
    private Radar radar;
    private List<BreakdownEnum> breakdowns;

    public MarsRover(int x, int y, String direction) {
        this.location = Location.build(x, y, direction);
        this.radar = new Radar();
        this.breakdowns = new ArrayList<>();
    }

    public MarsRover(int x, int y, String direction, Radar radar) {
        this.location = Location.build(x, y, direction);
        this.radar = radar;
        this.breakdowns = new ArrayList<>();
    }

    public MarsRover execute(String cmd) {
        Command command = Command.build(cmd);
        Location next = command.execute(location);
        if (this.radar.isMarkedTrap(next.getPosition())
            ||
            this.isBroken(command)) {
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

    public void broken(BreakdownEnum commandClass) {
        this.breakdowns.add(commandClass);
    }

    private boolean isBroken(Command command) {
        return this.breakdowns.stream()
            .anyMatch(item -> item.getCmdClass().equals(command.getClass()));
    }
}
