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

    @Test
    public void should_verify_position_is_trap() {
        marsMap = MarsMap.build(traps);
        assertTrue(marsMap.verify(Position.build(1, 1)));
        assertTrue(marsMap.verify(Position.build(3, 1)));
        assertFalse(marsMap.verify(Position.build(2, 1)));
    }

    @Test
    public void should_mark_trap_position_when_into_trap() {
        marsMap = MarsMap.build(traps);
        marsMap.verify(Position.build(1, 1));

        assertEquals(1,marsMap.getMarkTraps().size());
    }


}