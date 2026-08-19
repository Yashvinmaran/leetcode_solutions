class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, boolean[]> seatMap = new HashMap<>();
        
        for (int[] res : reservedSeats) {
            int row = res[0];
            int col = res[1];
            seatMap.putIfAbsent(row, new boolean[10]);
            seatMap.get(row)[col - 1] = true;
        }
        
        int ans = n * 2; 
        
        for (int row : seatMap.keySet()) {
            boolean[] seats = seatMap.get(row);
            
            ans -= 2; 
            
            boolean leftFree = !seats[1] && !seats[2] && !seats[3] && !seats[4];   // 2,3,4,5
            boolean rightFree = !seats[5] && !seats[6] && !seats[7] && !seats[8]; // 6,7,8,9
            boolean midFree = !seats[3] && !seats[4] && !seats[5] && !seats[6];   // 4,5,6,7
            
            if (leftFree && rightFree) {
                ans += 2;
            } else if (leftFree || rightFree || midFree) {
                ans += 1;
            }
        }
        
        return ans;
    }
}

