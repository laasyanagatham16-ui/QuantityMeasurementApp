public class QuantityMeasurementApp {

    // ✅ FEET CLASS
    static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        public double toInches() {
            return value * 12;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // ✅ INCHES CLASS
    static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        public double toInches() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // ✅ FEET vs FEET
    public static boolean compareFeet(double v1, double v2) {
        return new Feet(v1).equals(new Feet(v2));
    }

    // ✅ INCHES vs INCHES
    public static boolean compareInches(double v1, double v2) {
        return new Inches(v1).equals(new Inches(v2));
    }

    // ✅ FEET vs INCHES (UC2 IMPORTANT)
    public static boolean compareFeetAndInches(double feet, double inches) {
        Feet f = new Feet(feet);
        Inches i = new Inches(inches);

        return Double.compare(f.toInches(), i.toInches()) == 0;
    }

    // ✅ MAIN METHOD
    public static void main(String[] args) {

        // UC1
        System.out.println("Feet Equal (1.0, 1.0): " + compareFeet(1.0, 1.0));

        // UC2
        System.out.println("Inches Equal (1.0, 1.0): " + compareInches(1.0, 1.0));

        // Cross comparison
        System.out.println("1 ft == 12 inches: " + compareFeetAndInches(1.0, 12.0));
        System.out.println("1 ft == 10 inches: " + compareFeetAndInches(1.0, 10.0));
    }
}