class Solution {
    private static final double KELVIN_OFFSET = 273.15;
    private static final double FAHRENHEIT_MULT = 1.8;
    private static final double FAHRENHEIT_OFFSET = 32.0;

    public double[] convertTemperature(double celsius) {
        return new double[]{
            celsius + KELVIN_OFFSET, 
            celsius * FAHRENHEIT_MULT + FAHRENHEIT_OFFSET
        };
    }
}

