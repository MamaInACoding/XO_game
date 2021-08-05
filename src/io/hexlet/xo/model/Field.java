package io.hexlet.xo.model;


import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {
    private final int FIELD_SIZE = 3;
    public final int MIN_COORDINSTE = 0;
    private final Figure[][] figures = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getFIELD_SIZE() {
        return FIELD_SIZE;
    }

    public Figure getFigure(Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return figures[point.x][point.y];
    }

    public void setFigure(Point point, Figure figure) throws InvalidPointException, AlreadyOccupiedException {
        if (!checkPoint(point)){
            throw new InvalidPointException();
        }
        if (figures[point.x][point.y] != null) {
            throw new AlreadyOccupiedException();
        }
        figures[point.x][point.y] = figure;
    }

    public boolean checkPoint(Point point) {
        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }

    public boolean checkCoordinate (final int coordinate) {
        return coordinate >= MIN_COORDINSTE && coordinate < FIELD_SIZE;
    }
}
