package com.thoughtworks.marsrover.model.vo;

import com.thoughtworks.marsrover.model.MarsMap;

public class Radar implements ValueObject{
    private MarsMap marsMap = MarsMap.build();

    public Radar() {

    }

    public Radar(MarsMap marsMap) {
        this.marsMap = marsMap;
    }

    public static Radar build(MarsMap marsMap) {
        return new Radar(marsMap);
    }

    public boolean inTrap(Position position) {
        boolean inTrap = this.marsMap.getTraps()
            .stream()
            .anyMatch(item -> item.equals(position));
        if (inTrap) {
            this.marsMap.mark(position);
        }
        return inTrap;
    }

    public boolean isMarkedTrap(Position position) {
        return this.marsMap.getMarkTraps()
            .stream()
            .anyMatch(item -> item.equals(position));
    }
}
