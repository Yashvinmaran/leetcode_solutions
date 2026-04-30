class Solution {
    public String trafficSignal(int t) {
        return t == 0 ? "Green" : t == 30 ? "Orange" : (t > 30 && t <= 90) ? "Red" : "Invalid";
    }
}
