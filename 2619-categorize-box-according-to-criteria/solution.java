class Solution {
    public String categorizeBox(int l, int w, int h, int m) {

        boolean bulky = (l >= 10000 || w >= 10000 || h >= 10000);

        if (!bulky) {
            bulky = (long) l * w * h >= 1_000_000_000;
        }

        boolean heavy = m >= 100;

        if (bulky && heavy) return "Both";
        if (bulky) return "Bulky";
        if (heavy) return "Heavy";
        return "Neither";
    }
}
