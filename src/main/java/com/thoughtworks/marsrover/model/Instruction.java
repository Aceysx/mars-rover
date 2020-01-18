package com.thoughtworks.marsrover.model;

import com.thoughtworks.marsrover.command.*;

public enum Instruction {
    M(MoveCommand.class),
    B(BackwardCommand.class),
    L(TurnLeftCommand.class),
    R(TurnRightCommand.class),
    H(ForwardCommand.class);

    private Class commandClass;

    Instruction(Class commandClass) {
        this.commandClass = commandClass;
    }

    public Command command() throws IllegalAccessException, InstantiationException {
        return (Command) this.commandClass.newInstance();
    }
}
