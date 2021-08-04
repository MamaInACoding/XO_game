package io.hexlet.xo.model;

import java.awt.*;

public class Field {
    private final int FIELD_SIZE = 3;
    private final Figure[][] figures = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getFIELD_SIZE() {
        return FIELD_SIZE;
    }

    public Figure getFigure(Point point) {
        return figures[point.x][point.y];
    }

    public void setFigure(Point point, Figure figure) {
        figures[point.x][point.y] = figure;
    }
}
