package de.grafelhaft.polygoncalc.converter;

import java.util.List;

import de.grafelhaft.polygoncalc.model.IPoint;
import de.grafelhaft.polygoncalc.model.IPolygon;

import static de.grafelhaft.polygoncalc.Contants.EARTH_RADIUS_GRS80;
import static de.grafelhaft.polygoncalc.converter.LocationConverter.approxMeterToLatLng;
import static de.grafelhaft.polygoncalc.converter.LocationConverter.approxMeterToLat;
import static de.grafelhaft.polygoncalc.converter.LocationConverter.approxMeterToLng;

/**
 * Created by @author Markus Graf (Grafelhaft) on 21.09.2020
 */
public class Distance2LatLngConverter {
    private double radius;

    public Distance2LatLngConverter() {
        this.radius = EARTH_RADIUS_GRS80;
    }

    public Distance2LatLngConverter(double radius) {
        this.radius = radius;
    }

    public double convert(double meterLat) {
        return approxMeterToLat(meterLat, this.radius);
    }

    public double convert(double meterLat, double meterLng) {
        return approxMeterToLng(meterLat, meterLng, this.radius);
    }

    public IPoint[] convert(IPoint[] points) {
        return LocationConverter.approxMeterToLatLng(points, this.radius);
    }

    public List<IPoint> convert(List<IPoint> points) {
        return LocationConverter.approxMeterToLatLng(points, this.radius);
    }

    public <T extends IPoint> IPolygon<IPoint> convert(IPolygon<T> points) {
        return approxMeterToLatLng(points, this.radius);
    }

}
