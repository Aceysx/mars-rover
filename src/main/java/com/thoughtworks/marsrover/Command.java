package com.thoughtworks.marsrover;

public interface Command {

    Location execute(Location location);

    static Command build(String cmd) {
        if ("M".equals(cmd)) {
            return new MoveCommand();
        }
        if ("L".equals(cmd)) {
            return new TurnLeftCommand();
        }
        return new TurnRightCommand();
    }
}
