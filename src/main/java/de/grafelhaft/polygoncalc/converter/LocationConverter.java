package de.grafelhaft.polygoncalc.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import de.grafelhaft.polygoncalc.model.IPoint;
import de.grafelhaft.polygoncalc.model.IPolygon;
import de.grafelhaft.polygoncalc.model.Point;
import de.grafelhaft.polygoncalc.model.Polygon;

import static de.grafelhaft.polygoncalc.Constants.EARTH_RADIUS_GRS80;

/**
 * Created by @author Markus Graf (Grafelhaft) on 20.09.2020
 */
public class LocationConverter {

    public static double approxLatToMeter(double latitude) {
        return approxLatToMeter(latitude, EARTH_RADIUS_GRS80);
    }

    public static double approxLatToMeter(double latitude, double radius) {
        return radius * (Math.PI / 180) * latitude;
    }

    public static double approxLngToMeter(double latitude, double longitude, double radius) {
        return radius * (Math.PI / 180) * longitude * Math.cos(Math.toRadians(latitude));
    }


    public static Point approxLatLngToMeter(IPoint point, double radius) {
        double lat = point.x();
        double lng = point.y();
        double distLat = approxLatToMeter(lat, radius);
        double distLng = approxLngToMeter(lat, lng, radius);

        return new Point(distLat, distLng);
    }

    public static IPoint[] approxLatLngToMeter(IPoint[] points, double radius) {
        IPoint[] help = new Point[points.length];
        for (int i = 0; i < help.length; i++) {
            help[i] = approxLatLngToMeter(points[i], radius);
        }
        return help;
    }

    public static List<IPoint> approxLatLngToMeter(List<IPoint> points, double radius) {
        List<IPoint> temp = new ArrayList<>();
        for (IPoint p : points) {
            temp.add(approxLatLngToMeter(p, radius));
        }
        return Collections.unmodifiableList(temp);
    }

    public static <T extends IPoint> IPolygon<IPoint> approxLatLngToMeter(IPolygon<T> polygon, double radius) {
        return new Polygon(approxLatLngToMeter(polygon.getPoints(), radius));
    }
    

    public static double approxMeterToLat(double meterLat, double radius) {
        return meterLat / (radius * (Math.PI / 180));
    } 
    
    public static double approxMeterToLng(double meterLat, double meterLng, double radius) {
        return meterLng / (radius * (Math.PI / 180) * Math.cos(Math.toRadians(meterLat)));
    } 


    public static IPoint approxMeterToLatLng(IPoint point, double radius) {
        double lat = point.x();
        double lng = point.y();
        double distLat = approxMeterToLat(lat, radius);
        double distLng = approxMeterToLng(lat, lng, radius);

        return new Point(distLat, distLng);
    }

    public static IPoint[] approxMeterToLatLng(IPoint[] points, double radius) {
        IPoint[] help = new Point[points.length];
        for (int i = 0; i < help.length; i++) {
            help[i] = approxMeterToLatLng(points[i], radius);
        }
        return help;
    }

    public static List<IPoint> approxMeterToLatLng(List<IPoint> points, double radius) {
        List<IPoint> temp = new ArrayList<>();
        for (IPoint p : points) {
            temp.add(approxMeterToLatLng(p, radius));
        }
        return Collections.unmodifiableList(temp);
    }

    public static <T extends IPoint> IPolygon<IPoint> approxMeterToLatLng(IPolygon<T> polygon, double radius) {
        return new Polygon(approxMeterToLatLng(polygon.getPoints(), radius));
    }


    public static double calcAreaInSquareMeter(List<? extends IPoint> points, double radius) {
        List<IPoint> temp = new ArrayList<>();
        for (IPoint p : points) {
            temp.add(approxLatLngToMeter(p, radius));
        }
        return new Polygon(temp).area();
    }

    public static double calcAreaInSquareMeter(IPoint[] points, double radius) {
        return calcAreaInSquareMeter(Arrays.asList(points), radius);
    }

    public static <T extends IPoint> double calcAreaInSquareMeter(IPolygon<T> polygon, double radius) {
        return calcAreaInSquareMeter(polygon.getPoints(), radius);
    }


    public static double distance(IPoint p1, IPoint p2, double radius) {
        return radius * Math.acos(
                Math.sin(Math.toRadians(p1.x()))
                        * Math.sin(Math.toRadians(p2.x()))
                        + Math.cos(Math.toRadians(p1.x()))
                        * Math.cos(Math.toRadians(p2.x()))
                        * Math.cos(Math.toRadians(p2.y()) - Math.toRadians(p1.y()))
        );
    }
}
