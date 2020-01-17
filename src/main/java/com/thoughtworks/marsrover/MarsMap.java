package com.thoughtworks.marsrover;

import java.util.List;

public class MarsMap {
    private List<Position> traps;

    private MarsMap(List<Position> traps) {
        this.traps = traps;
    }

    public static MarsMap build(List<Position> traps) {
        return new MarsMap(traps);
    }

    public List<Position> getTraps() {
        return traps;
    }

    public boolean verify(Position position) {
        return this.traps.stream()
            .anyMatch(item -> item.equals(position));
    }
}
