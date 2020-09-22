package de.grafelhaft.polygoncalc.model;

import java.util.List;

public class Polygon implements IPolygon<IPoint> {

    private IPoint[] points;

    public Polygon(IPoint[] points) {
        this.points = points;
    }

    public Polygon(List<IPoint> points) {
        this(points.toArray(new IPoint[0]));
    }

    @Override
    public IPoint[] getPoints() {
        return this.points;
    }

    @Override
    public double area() {
        return IPolygon.area(this);
    }

    @Override
    public boolean contains(IPoint point) {
        return IPolygon.contains(this, point);
    }

    public boolean contains(double x, double y) {
        return IPolygon.contains(this, new Point(x, y));
    }

    @Override
    public IPoint centroid() {
        return IPolygon.centroid(this);
    }

    @Override
    public IPolygon<IPoint> scale(double scale) {
        this.points = IPolygon.scale(this, scale).toArray(new IPoint[0]);
        return this;
    }

}