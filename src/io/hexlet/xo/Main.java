package io.hexlet.xo;

import io.hexlet.xo.controllers.MoveController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Point;

import java.util.Arrays;

public class Main {

    public static void main(String... args) {
        final io.hexlet.xo.model.Field field = new io.hexlet.xo.model.Field();
        final MoveController mc = new MoveController();

        for (int i = 0; i < field.getSize(); i++) {
            for (int i2 = 0; i2 < field.getSize(); i2++) {
                final Point p = new Point(i, i2);
                field.setFigure(p, String.format("%d-%d", i, i2));
            }
        }
        for (int i = 0; i < field.getSize(); i++) {
            for (int i2 = 0; i2 < field.getSize(); i2++) {
                final Point p = new Point(i, i2);
                final String figure = String.format("%d-%d", i, i2);
                if (!field.getFigure(p).equals(figure)) {
                    throw new RuntimeException(String.format("Figure on X=%d, Y=%d equals to %s instead of %s!", i, i2, field.getFigure(p), figure));
                }
                field.setFigure(p, null);
            }
        }

        final Point p = new Point();
        p.x = 1;
        p.y = 1;
        if (!mc.applyFigure(field, p, "X")) {
            throw new RuntimeException("Method return false when applying figure to the empty items!");
        }

        java.lang.reflect.Field f = null;
        try {
            f = io.hexlet.xo.model.Field.class.getDeclaredField("figures");
            f.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            String[][] arrayInField = (String[][]) f.get(field);
            //System.out.println(Arrays.deepToString(arrayInField));

            if (!"X".equals(arrayInField[p.x][p.y])) {
                throw new RuntimeException("The figure \"X\" is not installed on the field!");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if (mc.applyFigure(field, p, "X")) {
            throw new RuntimeException("Method return true when applying figure to the non empty items!");
        }
        final Point p2 = new Point();
        p2.x = -1;
        p2.y = -1;
        if (mc.applyFigure(field, p2, "X")) {
            throw new RuntimeException("Method return true when applying figure to the (-1, -1)!");
        }

        final Point p3 = new Point();
        p3.x = -1;
        p3.y = 10;
        if (mc.applyFigure(field, p3, "X")) {
            throw new RuntimeException("Method return true when applying figure to the (-1, 10)!");
        }
    }
}