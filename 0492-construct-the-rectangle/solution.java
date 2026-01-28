class Solution {
    public int[] constructRectangle(int area) {
        // Start from the square root to minimize the difference |L - W|
        int w = (int) Math.sqrt(area);
        
        // Find the largest width that is <= sqrt(area) and divides area evenly
        while (area % w != 0) {
            w--;
        }
        
        // Since we started from sqrt and went down, L will be >= W
        return new int[] {area / w, w};
    }
}

