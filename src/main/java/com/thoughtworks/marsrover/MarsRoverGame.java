package com.thoughtworks.marsrover;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarsRoverGame {
    private List<MarsRover> marsRovers;

    public MarsRoverGame(MarsRover firstMarsRover) {
        marsRovers = new ArrayList<>();
        marsRovers.add(firstMarsRover);
    }

    public void start(String cmd) {
        MarsRover marsRover = getCurrentMarsRover();
        marsRover.execute(cmd);
        if (marsRover.inTrap()) {
            this.startNewMarsRover();
        }
    }

    private void startNewMarsRover() {
        marsRovers.add(new MarsRover(0, 0, "N"));
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
