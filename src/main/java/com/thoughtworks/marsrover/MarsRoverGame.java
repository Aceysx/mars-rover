package com.thoughtworks.marsrover;

import com.thoughtworks.marsrover.model.Instruction;
import com.thoughtworks.marsrover.model.marsRover.DefaultMarsRover;
import com.thoughtworks.marsrover.model.marsRover.MarsRover;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarsRoverGame {
    private List<MarsRover> marsRovers;

    public MarsRoverGame(MarsRover firstMarsRover) {
        marsRovers = new ArrayList<>();
        marsRovers.add(firstMarsRover);
    }

    public void start(Instruction instruction) {
        MarsRover marsRover = getCurrentMarsRover();
        marsRover.execute(instruction);
        if (marsRover.inTrap()) {
            this.startNewMarsRover();
        }
    }

    private void startNewMarsRover() {
        marsRovers.add(new DefaultMarsRover(0, 0, "N"));
    }

    private MarsRover getCurrentMarsRover() {
        return this.getMarsRovers().get(getMarsRovers().size() - 1);
    }

    public List<MarsRover> inTrapsMarsRover() {
        return this.getMarsRovers().stream()
            .filter(MarsRover::inTrap)
            .collect(Collectors.toList());
    }

    public List<MarsRover> getMarsRovers() {
        return marsRovers;
    }
}
