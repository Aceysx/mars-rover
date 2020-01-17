package com.thoughtworks.marsrover.command;

import com.thoughtworks.marsrover.Location;

public class BackwardCommand implements Command {

    @Override
    public Location execute(Location location) {
        if (location.isBackward()) {
            return location;
        }
        return location.reverse();
    }
}