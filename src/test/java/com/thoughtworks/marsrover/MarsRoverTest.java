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

    @Test
    public void should_change_position_when_receive_move_cmd() {
        MarsRover withNDirection = new MarsRover(0, 0, "N");
        withNDirection = withNDirection.execute("M");
        assertEquals(Position.build(0, 1), withNDirection.getPosition());
        assertEquals("N", withNDirection.getDirection());

        MarsRover withWDirection = new MarsRover(0, 0, "W");
        withWDirection = withWDirection.execute("M");
        assertEquals(Position.build(-1, 0), withWDirection.getPosition());
        assertEquals("W", withWDirection.getDirection());
    }


}