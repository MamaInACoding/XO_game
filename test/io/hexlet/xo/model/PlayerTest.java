package io.hexlet.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getName() {
        String inputValue = "Feruza";
        String expectedValue = inputValue;
        Player player = new Player(inputValue, null);
        String actualValue = player.getName();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getFigure() {
        Figure inputValue = Figure.X;
        Figure expectedValue = inputValue;
        Player player = new Player(null, inputValue);
        Figure actualValue = player.getFigure();
        assertEquals(expectedValue, actualValue);
    }
}