package de.grafelhaft.polygoncalc;

import java.util.Locale;

/**
 * Created by @author Markus Graf (Grafelhaft) on 20.09.2020
 */
public class MathUtils {

    public static String format2Decimals(double value) {
        return String.format(Locale.US, "%.2f", value);
    }

    public static String format2Decimals(double value, int decimals) {
        return String.format(Locale.US, "%." + decimals + "f", value);
    }

    public static String formatDecimalToPercent(double value) {
        return Integer.toString((int) (value * 100));
    }

}
