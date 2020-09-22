# PolygonCalc
This library:
- can find the [convex hull](https://en.wikipedia.org/wiki/Convex_hull) of a list of points
- can calculate the area of a polygon
- can calculate the distance between two GPS coordinates


### How to find the convex hull of a list of points:

Right now, there are two different algorithms implemented to find a convex hull
- [QuickHull](https://en.wikipedia.org/wiki/Quickhull)
- [GrahamScan](https://en.wikipedia.org/wiki/Graham_scan)

```java
IPoint[] points = {
          new Point(0,0),
          new Point(1.5,1),
          new Point(1,1.5),
          new Point(0.5,0.5),
          new Point(2,1),
          new Point(1,2),
          new Point(2,2),
        };

IPoint[] convexHullQuick = ConvexHull.getConvexHull(points, ConvexHull.Algorithm.QUICK_HULL);
IPoint[] convexHullGraham = ConvexHull.getConvexHull(points, ConvexHull.Algorithm.GRAHAM_SCAN);
```

### How to calculate the area of a polygon:

Before calculating the area of a polygon, it makes sense to find its convex hull first. 
Otherwise you might get strange/wrong results. 
```java
IPoint[] points = {
                new Point(0,0),
                new Point(0,2),
                new Point(2,2),
                new Point(2,0),
        };

IPolygon<IPoint> polygon = new Polygon(points);

double result = polygon.area();
```

### How to calculate the distance in meters between two GPS coordinates:

You can provide different earth's radius regarding which model you are using.
The library provides three GRS80 radii:
- EARTH_RADIUS_GRS80 = 6371000.8;
- EARTH_RADIUS_GRS80_Polar = 6356752.314;
- EARTH_RADIUS_GRS80_Equator = 6378137.0;

```java
IPoint p1 = new Point(52.516288, 13.377886); // Berlin
IPoint p2 = new Point(38.780453, -9.498910); // Cabo da roca

double distanceInMeter = LocationConverter.distance(p1, p2, Contants.EARTH_RADIUS_GRS80);
```

### How to calculate the area in meters between GPS coordinates:

Furthermore you are able to calculate the area of a polygon using GPS coordinates (latitude, longitude):

```java
IPoint p1 = new Point(48.13726, 11.57558);
IPoint p2 = new Point(48.16875, 11.55033);
IPoint p3 = new Point(48.16511, 11.60661);

double areaInSquareMeter = LocationConverter.calcAreaInSquareMeter(new IPoint[] {p1, p2, p3}, Contants.EARTH_RADIUS_GRS80);
```
