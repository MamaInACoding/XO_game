package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {
    public Figure currentFigure(final Field field) {
        int countFigure = 0;

        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                try {
                    if (field.getFigure(new Point(i, j)) != null) {
                        countFigure++;
                    }
                } catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }

        }
        if (countFigure == field.getSize() * field.getSize()) return null;
        if (countFigure % 2 == 0) return Figure.X;
        return Figure.O;
    }
}
