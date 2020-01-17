package com.thoughtworks.marsrover.model;

import com.thoughtworks.marsrover.MarsMap;
import com.thoughtworks.marsrover.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RadarTest {
    @Mock
    private MarsMap marsMap;
    private Radar radar;

    @Test
    public void should_verify_mars_rover_into_trap() {
        Position position = Position.build(1, 1);
        when(marsMap.verify(position)).thenReturn(true);
        radar = Radar.build(marsMap);

        assertTrue(radar.inTrap(position));
    }
}