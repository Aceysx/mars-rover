package com.thoughtworks.marsrover.model.marsRover;

import com.thoughtworks.marsrover.command.Command;
import com.thoughtworks.marsrover.command.CommandFactory;
import com.thoughtworks.marsrover.model.BreakdownEnum;
import com.thoughtworks.marsrover.model.Instruction;
import com.thoughtworks.marsrover.model.vo.Location;
import com.thoughtworks.marsrover.model.vo.Position;
import com.thoughtworks.marsrover.model.vo.Radar;

import java.util.ArrayList;
import java.util.List;

public abstract class MarsRover {
    Location location;
    Radar radar;
    List<BreakdownEnum> breakdowns;

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

    public MarsRover execute(Instruction instruction) {
        Command command = CommandFactory.build(instruction);
        Location next = command.execute(location);
        if (canMove(instruction, command, next)) {
            this.updateLocation(next);
        }
        return this;
    }

    private boolean canMove(Instruction instruction, Command command, Location next) {
        return !(this.hasTraps(instruction, next)
            ||
            this.isBroken(command));
    }

    abstract boolean hasTraps(Instruction cmd, Location next);

    public boolean inTrap() {
        return radar.inTrap(this.location.getPosition());
    }

    ;

    public Position getPosition() {
        return location.getPosition();
    }

    String getDirection() {
        return location.getDirection().toString();
    }


    boolean isBackward() {
        return this.location.isBackward();
    }

    void broken(BreakdownEnum commandClass) {
        this.breakdowns.add(commandClass);
    }

    private void updateLocation(Location location) {
        this.location = location;
    }

    boolean isBroken(Command command) {
        return this.breakdowns.stream()
            .anyMatch(item -> item.getCmdClass().equals(command.getClass()));
    }
}
