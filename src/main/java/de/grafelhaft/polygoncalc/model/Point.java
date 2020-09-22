package de.grafelhaft.polygoncalc.model;

/**
 * Created by @author Markus Graf (Grafelhaft) on 20.09.2020
 */
public class Point implements IPoint {

    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double x() {
        return this.x;
    }

    @Override
    public double y() {
        return this.y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "|" + this.y + ")";
    }
}
