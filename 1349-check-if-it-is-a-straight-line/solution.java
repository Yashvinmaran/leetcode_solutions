class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // Find the differences of the first two coordinates to get the base slope
        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];
        
        // Compare the slope of the first point with every subsequent point
        for (int i = 2; i < coordinates.length; i++) {
            int currentDx = coordinates[i][0] - coordinates[0][0];
            int currentDy = coordinates[i][1] - coordinates[0][1];
            
            // Using cross multiplication to avoid division by zero
            if (currentDx * dy != currentDy * dx) {
                return false;
            }
        }
        return true;
    }
}

