package com.thoughtworks.marsrover.model;

import com.thoughtworks.marsrover.model.vo.Position;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Math.random;

public class MarsMap {
    private List<Position> traps;
    private Set<Position> markTraps;

    private MarsMap(List<Position> traps) {
        this.traps = traps;
        this.markTraps = new HashSet<>();
    }

    public static MarsMap build() {
        List<Position> DEFAULT_TRAPS = Arrays.asList(
            Position.build((int) (random() * 50) + 1, (int) (random() * 50) + 1),
            Position.build((int) (random() * 100) + 50, (int) (random() * 100) + 50)
        );
        return new MarsMap(DEFAULT_TRAPS);
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
