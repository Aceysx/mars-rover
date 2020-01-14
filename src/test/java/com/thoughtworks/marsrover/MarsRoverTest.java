package com.thoughtworks.marsrover;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverTest {

    @Test
    public void should_init_marsRover() {
        Position position = Position.build(0, 0);
        MarsRover marsRover = new MarsRover(0, 0, "N");
        assertEquals(position, marsRover.getPosition());
        assertEquals("N", marsRover.getDirection());
    }

}