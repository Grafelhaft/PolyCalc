package de.grafelhaft.polygoncalc.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.grafelhaft.polygoncalc.model.IPoint;

/**
 * Created by @author Markus Graf (Grafelhaft) on 20.09.2020
 */
public class ConvexHull {

    public enum Algorithm {
        QUICK_HULL,
        GRAHAM_SCAN
    }

    public static IPoint[] getConvexHull(IPoint[] points, Algorithm algorithm) {
        List<? extends IPoint> temp = getConvexHull(new ArrayList<IPoint>(Arrays.asList(points)), algorithm);
        return temp.toArray(new IPoint[0]);
    }

    public static List<? extends IPoint> getConvexHull(List<? extends IPoint> points, Algorithm algorithm) {
        switch (algorithm) {
            case QUICK_HULL:
                return QuickHull.getConvexHull(points);
            case GRAHAM_SCAN:
                return GrahamScan.getConvexHull(points);
            default:
                throw new RuntimeException("Not Implemented");
        }
    }

}
