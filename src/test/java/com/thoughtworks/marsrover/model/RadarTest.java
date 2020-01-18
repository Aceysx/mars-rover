package com.thoughtworks.marsrover.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RadarTest {
    @Mock
    private MarsMap marsMap;
    private Radar radar;
    private List<Position> traps = Arrays.asList(
        Position.build(1, 1),
        Position.build(1, 2)
    );
    @Test
    public void should_verify_mars_rover_into_trap() {
        Position position = Position.build(1, 1);
        when(marsMap.getTraps()).thenReturn(traps);

        radar = Radar.build(marsMap);
        assertTrue(radar.inTrap(position));
    }

    @Test
    public void should_verify_position_is_marked() {
        Position position = Position.build(1, 1);
        HashSet<Position> marked = new HashSet<>();
        marked.add(position);
        when(marsMap.getMarkTraps()).thenReturn(marked);
        radar = Radar.build(marsMap);

        assertTrue(radar.isMarkedTrap(position));
    }

}