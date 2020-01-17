package com.thoughtworks.marsrover;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MarsMapTest {

    private MarsMap marsMap;
    private List traps = Arrays.asList(
        Position.build(1, 1),
        Position.build(3, 1)
    );

    @Test
    public void should_save_multiple_traps() {
        marsMap = MarsMap.build(traps);
        assertEquals(2, marsMap.getTraps().size());
    }
}