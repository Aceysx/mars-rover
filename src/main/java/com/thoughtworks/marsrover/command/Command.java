package com.thoughtworks.marsrover.command;

import com.thoughtworks.marsrover.model.vo.Location;

public interface Command {

    Location execute(Location location);
}
