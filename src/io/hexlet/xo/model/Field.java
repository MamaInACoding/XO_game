package io.hexlet.xo.model;


import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {
    public final int MIN_COORDINATE = 0;
    private final int fieldSize;
    private final Figure[][] field;

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
    }


    public int getFIELD_SIZE() {

        return fieldSize;
    }

    public Figure getFigure(Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(Point point, Figure figure) throws InvalidPointException {
        if (!checkPoint(point)){
            throw new InvalidPointException();
        }

        field[point.x][point.y] = figure;
    }

    public boolean checkPoint(Point point) {
        return checkCoordinate(point.x, field.length) || checkCoordinate(point.y, field[point.x].length);
    }

    public boolean checkCoordinate (final int coordinate, final  int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }
}
