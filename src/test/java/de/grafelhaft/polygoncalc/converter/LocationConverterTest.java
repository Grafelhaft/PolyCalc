package de.grafelhaft.polygoncalc.converter;

import de.grafelhaft.polygoncalc.Contants;
import de.grafelhaft.polygoncalc.MathUtils;
import de.grafelhaft.polygoncalc.model.IPoint;
import de.grafelhaft.polygoncalc.model.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationConverterTest {

    @Test
    public void convertLatLangToMeters_1() {
        IPoint point = new Point(1, 1);

        IPoint result = LocationConverter.approxLatLngToMeter(point, Contants.EARTH_RADIUS_GRS80);
        String x = MathUtils.format2Decimals(result.x());
        String y = MathUtils.format2Decimals(result.y());

        assertEquals("111194.94", x);
        assertEquals("111178.01", y);
    }

    @Test
    public void convertLatLangToMeters_2() {
        IPoint point1 = new Point(1, 0);
        IPoint point2 = new Point(0, 1);

        IPoint result1 = LocationConverter.approxLatLngToMeter(point1, Contants.EARTH_RADIUS_GRS80);
        IPoint result2 = LocationConverter.approxLatLngToMeter(point2, Contants.EARTH_RADIUS_GRS80);
        String x = MathUtils.format2Decimals(result1.x());
        String y = MathUtils.format2Decimals(result2.y());

        assertEquals(x, y);
    }

    @Test
    public void convertLatLangToMeters_3() {
        IPoint maxLatitude = new Point(0, 90);
        IPoint maxLongitude = new Point(180, 0);

        IPoint result1 = LocationConverter.approxLatLngToMeter(maxLatitude, Contants.EARTH_RADIUS_GRS80);
        IPoint result2 = LocationConverter.approxLatLngToMeter(maxLongitude, Contants.EARTH_RADIUS_GRS80);

        assertEquals(result1.x(), result2.y() / 2, 0);
    }

    @Test
    public void distance() {
        IPoint p1 = new Point(52.516288, 13.377886); // Berlin
        IPoint p2 = new Point(38.780453, -9.498910); // Cabo da roca

        double distanceInKilometer = LocationConverter.distance(p1, p2, Contants.EARTH_RADIUS_GRS80 / 1000);
        assertEquals(2326, distanceInKilometer, 1);
    }

    @Test
    public void distance_lat() {
        IPoint p0 = new Point(0, 0);
        IPoint p1 = new Point(1, 0);

        double result1 = LocationConverter.approxLatToMeter(1);
        double result2 = LocationConverter.distance(p0, p1, Contants.EARTH_RADIUS_GRS80);

        assertEquals(result1, result2, 1);
    }

    @Test
    public void distance_lng() {
        IPoint p0 = new Point(0, 0);
        IPoint p1 = new Point(0, 1);

        double result1 = LocationConverter.approxLngToMeter(0, 1, Contants.EARTH_RADIUS_GRS80);
        double result2 = LocationConverter.distance(p0, p1, Contants.EARTH_RADIUS_GRS80);

        assertEquals(result1, result2, 1);
    }

}