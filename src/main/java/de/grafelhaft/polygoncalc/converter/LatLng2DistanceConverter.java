package de.grafelhaft.polygoncalc.converter;

import java.util.List;

import de.grafelhaft.polygoncalc.model.IPoint;
import de.grafelhaft.polygoncalc.model.IPolygon;

import static de.grafelhaft.polygoncalc.Constants.EARTH_RADIUS_GRS80;
import static de.grafelhaft.polygoncalc.converter.LocationConverter.approxLatLngToMeter;
import static de.grafelhaft.polygoncalc.converter.LocationConverter.approxLatToMeter;
import static de.grafelhaft.polygoncalc.converter.LocationConverter.approxLngToMeter;

/**
 * Created by @author Markus Graf (Grafelhaft) on 21.09.2020
 */
public class LatLng2DistanceConverter {
    private double radius;

    public LatLng2DistanceConverter() {
        this.radius = EARTH_RADIUS_GRS80;
    }

    public LatLng2DistanceConverter(double radius) {
        this.radius = radius;
    }

    public double convert(double latitude) {
        return approxLatToMeter(latitude, this.radius);
    }

    public double convert(double latitude, double longitude) {
        return approxLngToMeter(latitude, longitude, this.radius);
    }

    public IPoint convert(IPoint latLng) {
        return LocationConverter.approxLatLngToMeter(latLng, this.radius);
    }

    public IPoint[] convert(IPoint[] latLngs) {
        return LocationConverter.approxLatLngToMeter(latLngs, this.radius);
    }

    public List<IPoint> convert(List<IPoint> latLngs) {
        return LocationConverter.approxLatLngToMeter(latLngs, this.radius);
    }

    public <T extends IPoint> IPolygon<IPoint> convert(IPolygon<T> polygon) {
        return approxLatLngToMeter(polygon, this.radius);
    }
}
