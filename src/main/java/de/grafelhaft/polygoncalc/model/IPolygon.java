package de.grafelhaft.polygoncalc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by @author Markus Graf (Grafelhaft) on 20.09.2020
 */
public interface IPolygon<T extends IPoint> {
    T[] getPoints();
    double area();
    boolean contains(T point);
    T centroid();
    IPolygon<T> scale(double scale);

    static Point scale(IPoint start, IPoint point, double scale) {
        double x = start.x() + ((point.x() - start.x()) * scale);
        double y = start.y() + ((point.y() - start.y()) * scale);
        return new Point(x, y);
    }

    static <T extends IPoint> List<IPoint> scale(IPolygon<T> polygon, double scale) {
        List<IPoint> newPoints = new ArrayList<>(polygon.getPoints().length);
        for (IPoint p : polygon.getPoints()) {
            newPoints.add(scale(polygon.centroid(), p, scale));
        }
        return Collections.unmodifiableList(newPoints);
    }

    static <T extends IPoint> boolean contains(IPolygon<T> polygon, IPoint point) {
        boolean c = false;
        int i, j = 0;
        for (i = 0, j = polygon.getPoints().length - 1; i < polygon.getPoints().length; j = i++) {
            if (((polygon.getPoints()[i].y() > point.y()) != (polygon.getPoints()[j].y() > point.y()))
                    && (point.x() < (polygon.getPoints()[j].x() - polygon.getPoints()[i].x()) * (point.y() - polygon.getPoints()[i].y()) / (polygon.getPoints()[j].y() - polygon.getPoints()[i].y()) + polygon.getPoints()[i].x()))
                c = !c;
        }
        return c;
    }

    static <T extends IPoint> double area(IPolygon<T> polygon) {
        double area = 0;         // Accumulates area in the loop
        int j = polygon.getPoints().length - 1;  // The last vertex is the 'previous' one to the first

        for (int i = 0; i < polygon.getPoints().length; i++) {
            area = area + (polygon.getPoints()[j].x() + polygon.getPoints()[i].x()) * (polygon.getPoints()[j].y() - polygon.getPoints()[i].y());
            j = i;  //j is previous vertex to i
        }
        return Math.abs(area / 2);
    }

    static <T extends IPoint> IPoint centroid(IPolygon<T> polygon) {
        double x = 0, y = 0;

        for (IPoint p : polygon.getPoints()) {
            x += p.x();
            y += p.y();
        }

        return new Point(x/polygon.getPoints().length, y/polygon.getPoints().length);
    }
}
