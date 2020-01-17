package com.thoughtworks.marsrover.model;

import com.thoughtworks.marsrover.MarsMap;
import com.thoughtworks.marsrover.Position;

public class Radar {
    private MarsMap marsMap;

    public Radar(MarsMap marsMap) {
        this.marsMap = marsMap;
    }

    public static Radar build(MarsMap marsMap) {
        return new Radar(marsMap);
    }

    public boolean inTrap(Position position) {
        return this.marsMap.verify(position);
    }
}
