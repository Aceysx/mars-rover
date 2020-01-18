package com.thoughtworks.marsrover.model.marsRover;

import com.thoughtworks.marsrover.model.Instruction;
import com.thoughtworks.marsrover.model.vo.Position;
import com.thoughtworks.marsrover.model.vo.Radar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BusMarsRoverTest {
    @Mock
    private Radar radar;

    @Test
    public void should_stop_when_turn_left_and_right_has_a_trap() {
        when(radar.isMarkedTrap(any())).thenReturn(true);

        MarsRover marsRover = new BusMarsRover(0, 0, "N", radar);
        marsRover.execute(Instruction.L);
        verify(radar, times(1)).isMarkedTrap(any());
        assertEquals(Position.build(0, 0), marsRover.getPosition());
    }

    @Test
    public void should_stop_when_turn_right_and_left_has_a_trap() {
        when(radar.isMarkedTrap(any())).thenReturn(true);

        MarsRover marsRover = new BusMarsRover(0, 0, "N", radar);
        marsRover.execute(Instruction.R);
        verify(radar, times(1)).isMarkedTrap(any());
        assertEquals(Position.build(0, 0), marsRover.getPosition());
    }
}