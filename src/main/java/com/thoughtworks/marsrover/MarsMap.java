package com.thoughtworks.marsrover;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MarsMap {
    private List<Position> traps;
    private Set<Position> markTraps;

    private MarsMap(List<Position> traps) {
        this.traps = traps;
        this.markTraps = new HashSet<>();
    }

    public static MarsMap build(List<Position> traps) {
        return new MarsMap(traps);
    }

    public List<Position> getTraps() {
        return traps;
    }

    public Set<Position> getMarkTraps() {
        return this.markTraps;
    }

    public void mark(Position position) {
        this.markTraps.add(position);
    }
}
