package com.thoughtworks.marsrover;

import com.thoughtworks.marsrover.model.marsRover.MarsRover;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MarsRoverGameTest {

    private MarsRoverGame marsRoverGame;
    @Mock
    private MarsRover firstMarsRover;

    @Before
    public void setUp() {
        marsRoverGame = new MarsRoverGame(firstMarsRover);
    }

    @Test
    public void should_start_another_car_when_first_car_move_into_trap() {
        when(firstMarsRover.inTrap()).thenReturn(true);
        String cmd = "M";
        marsRoverGame.start(cmd);
        List<MarsRover> marsRovers = marsRoverGame.inTrapsMarsRover();
        assertEquals(1, marsRovers.size());
        assertEquals(2, marsRoverGame.getMarsRovers().size());
    }

}