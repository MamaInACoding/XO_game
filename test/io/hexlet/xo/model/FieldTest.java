package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getFIELD_SIZE() {
        final Field field = new Field();
        assertEquals(3, field.getFIELD_SIZE());
    }

    @Test
    public void setFigure() throws InvalidPointException {
        final Field field = new Field();
        final Point point = new Point(0,0);
        final Figure figure = Figure.O;

        field.setFigure(point, figure);

        Figure actualFigure = field.getFigure(point);
        assertEquals(figure, actualFigure);
    }
}