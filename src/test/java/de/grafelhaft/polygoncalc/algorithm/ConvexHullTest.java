package de.grafelhaft.polygoncalc.algorithm;

import de.grafelhaft.polygoncalc.model.IPoint;
import de.grafelhaft.polygoncalc.model.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConvexHullTest {

    @Test
    public void getConvexHull_QuickHull() {
        IPoint[] points = {
          new Point(0,0),
          new Point(1.5,1),
          new Point(1,1.5),
          new Point(0.5,0.5),
          new Point(2,1),
          new Point(1,2),
          new Point(2,2),
        };

        IPoint[] convexHull = ConvexHull.getConvexHull(points, ConvexHull.Algorithm.QUICK_HULL);

        assertEquals(4, convexHull.length);
    }
}