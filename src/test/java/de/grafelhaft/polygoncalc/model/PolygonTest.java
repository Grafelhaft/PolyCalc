package de.grafelhaft.polygoncalc.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PolygonTest {

    @Test
    public void contains() {
        IPoint[] points = {
                new Point(0,0),
                new Point(0,2),
                new Point(2,2),
                new Point(2,0),
        };

        IPolygon<IPoint> polygon = new Polygon(points);

        boolean result = polygon.contains(new Point(1, 1));

        assertEquals(true, result);
    }

    @Test
    public void area() {
        IPoint[] points = {
                new Point(0,0),
                new Point(0,2),
                new Point(2,2),
                new Point(2,0),
        };

        IPolygon<IPoint> polygon = new Polygon(points);

        double result = polygon.area();

        assertEquals(4, result, 0);
    }

    @Test
    public void centroid() {
        IPoint[] points = {
                new Point(0,0),
                new Point(0,2),
                new Point(2,2),
                new Point(2,0),
        };

        IPolygon<IPoint> polygon = new Polygon(points);

        IPoint result = polygon.centroid();

        assertEquals(1, result.x(), 0);
        assertEquals(1, result.y(), 0);
    }

    @Test
    public void scale() {
        IPoint[] points = {
                new Point(0,0),
                new Point(0,2),
                new Point(2,2),
                new Point(2,0),
        };

        IPolygon<IPoint> polygon = new Polygon(points);

        polygon = polygon.scale(2);

        IPoint[] expected = {
                new Point(-1, -1),
                new Point(3, 3),
                new Point(3, -1),
                new Point(-1, 3),
        };

    }

}