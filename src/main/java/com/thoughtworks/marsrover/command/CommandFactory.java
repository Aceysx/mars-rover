package com.thoughtworks.marsrover.command;

import com.thoughtworks.marsrover.model.Instruction;

public class CommandFactory {

    public static Command build(Instruction instruction) {
        try {
            return instruction.command();
        } catch (Exception e) {
            throw new RuntimeException("cast command error");
        }
    }
}
