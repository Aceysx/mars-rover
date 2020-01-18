package com.thoughtworks.marsrover;

import com.thoughtworks.marsrover.model.MarsMap;
import com.thoughtworks.marsrover.model.Position;
import org.junit.Test;

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