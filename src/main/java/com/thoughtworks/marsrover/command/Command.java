package com.thoughtworks.marsrover.command;

import com.thoughtworks.marsrover.Location;

public interface Command {

    Location execute(Location location);

    static Command build(String cmd) {
        if ("M".equals(cmd)) {
            return new MoveCommand();
        }
        if ("L".equals(cmd)) {
            return new TurnLeftCommand();
        }
        if ("R".equals(cmd)) {
            return new TurnRightCommand();
        }
        if ("B".equals(cmd)) {
            return new BackwardCommand();
        }
        if ("H".equals(cmd)) {
            return new ForwardCommand();
        }
        throw  new RuntimeException("error cmd");
    }
}
