package io.hexlet.xo.model;

import static java.lang.String.*;

public class Field {

    private String f00;

    private String f01;

    private String f02;

    private String f10;

    private String f11;

    private String f12;

    private String f20;

    private String f21;

    private String f22;

    public int getSize() {
        return 3;
    }

    public String getFigure(final Point point) {
        // BEGIN (write your solution here)
        if (point.x == 0 && point.y == 0) return f00;
        if (point.x == 1 && point.y == 0) return f10;
        if (point.x == 2 && point.y == 0) return f20;
        if (point.x == 0 && point.y == 1) return f01;
        if (point.x == 1 && point.y == 1) return f11;
        if (point.x == 2 && point.y == 1) return f21;
        if (point.x == 0 && point.y == 2) return f02;
        if (point.x == 1 && point.y == 2) return f12;
        if (point.x == 2 && point.y == 2) return f22;
        // END
        return null;
    }

    public void setFigure(final Point point, final String figure) {
        // BEGIN (write your solution here)

        if (point.x == 0 && point.y == 0) f00 = figure;
        if (point.x == 1 && point.y == 0) f10 = figure;
        if (point.x == 2 && point.y == 0) f20 = figure;
        if (point.x == 0 && point.y == 1) f01 = figure;
        if (point.x == 1 && point.y == 1) f11 = figure;
        if (point.x == 2 && point.y == 1) f21 = figure;
        if (point.x == 0 && point.y == 2) f02 = figure;
        if (point.x == 1 && point.y == 2) f12 = figure;
        if (point.x == 2 && point.y == 2) f22 = figure;

        // END

    }


}
