package com.thoughtworks.marsrover.model;

import com.thoughtworks.marsrover.command.*;

public enum BreakdownEnum {
    FORWARD(MoveCommand.class),
    BACKWARD(BackwardCommand.class),
    TURN_LEFT(TurnLeftCommand.class),
    TURN_RIGHT(TurnRightCommand.class);
    private Class cmdClass;

    BreakdownEnum(Class cmdClass) {
        this.cmdClass = cmdClass;
    }

    public Class getCmdClass() {
        return cmdClass;
    }
}
