package com.thoughtworks.marsrover;

import com.thoughtworks.marsrover.model.MarsRover;
import com.thoughtworks.marsrover.model.Position;
import com.thoughtworks.marsrover.model.Radar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MarsRoverTest {
    @Mock
    private Radar radar;

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

    @Test
    public void should_change_direction_when_receive_L_cmd() {
        MarsRover marsRover = new MarsRover(0, 0, "N");
        marsRover = marsRover.execute("L");
        assertEquals(Position.build(0, 0), marsRover.getPosition());
        assertEquals("W", marsRover.getDirection());

        marsRover = marsRover.execute("L");
        assertEquals("S", marsRover.getDirection());

        marsRover = marsRover.execute("R");
        assertEquals("W", marsRover.getDirection());
    }

    @Test
    public void should_enter_backward_state_when_receive_B_cmd() {
        MarsRover marsRover = new MarsRover(0, 0, "N");
        marsRover = marsRover.execute("B");

        assertTrue(marsRover.isBackward());
    }

    @Test
    public void should_enter_forward_state_when_receive_H_cmd() {
        MarsRover marsRover = new MarsRover(0, 0, "N");
        marsRover = marsRover.execute("H");

        assertFalse(marsRover.isBackward());
    }

    @Test
    public void should_go_correct_direction_when_backward() {
        MarsRover marsRover = new MarsRover(0, 0, "N");
        marsRover = marsRover.execute("B");

        marsRover.execute("M");
        assertEquals(Position.build(0, -1), marsRover.getPosition());

        marsRover.execute("M");
        assertEquals(Position.build(0, -2), marsRover.getPosition());

        marsRover.execute("L");
        assertEquals(Position.build(0, -2), marsRover.getPosition());
        assertEquals("E", marsRover.getDirection());

        marsRover.execute("L");
        assertEquals(Position.build(0, -2), marsRover.getPosition());
        assertEquals("N", marsRover.getDirection());

        marsRover.execute("M");
        assertEquals(Position.build(0, -1), marsRover.getPosition());

        marsRover.execute("H");
        assertEquals("S", marsRover.getDirection());
        assertEquals(Position.build(0, -1), marsRover.getPosition());
    }

    @Test
    public void should_mark_trap_when_car_move_into_a_trap_not_mark() {
        Position trapPosition = Position.build(0, 1);
        when(radar.inTrap(trapPosition)).thenReturn(true);
        MarsRover marsRover = new MarsRover(0, 0, "N", radar);
        marsRover.execute("M");
        assertTrue(marsRover.inTrap());
        verify(radar, times(1)).inTrap(trapPosition);
    }

    @Test
    public void should_stop_when_car_move_into_a_mark_trap() {
        Position trapPosition = Position.build(0, 1);
        when(radar.isMarkedTrap(trapPosition)).thenReturn(true);
        MarsRover marsRover = new MarsRover(0, 0, "N", radar);
        marsRover.execute("M");
        assertEquals(Position.build(0, 0), marsRover.getPosition());
    }

}