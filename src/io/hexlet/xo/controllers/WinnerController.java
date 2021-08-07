package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {
    public Figure getWinner(Field field) {
        try {
            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1))) {
                    return field.getFigure(new Point(i, 0));
                }

                for (i = 0; i < 3; i++) {
                    if (check(field, new Point(i, 0), p -> new Point(p.x + 1, p.y ))) {
                        return field.getFigure(new Point(0, i));
                    }

                    if (check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1))) {
                        return field.getFigure(new Point(0, 0));
                    }

                    if (check(field, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1))) {
                        return field.getFigure(new Point(0, 2));
                    }
                }

            }
        } catch (InvalidPointException invalidPointException) {
            invalidPointException.printStackTrace();
        }

        return null;
}


    public boolean check(Field field, final Point currentPoint, IPointGenerator pointGenerator ) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(nextPoint);

        } catch (InvalidPointException e) {
            return false;
        }
        if (currentFigure == null) return false;
        if (currentFigure != nextFigure) return false;

        return check(field, nextPoint, pointGenerator);
    }


    private interface IPointGenerator {
        Point next(final Point point);
    }
}
