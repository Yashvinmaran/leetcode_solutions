class Solution {

    private static int eatingTimeAtSpeekOf(int[] piles, int k) {

        int sum = 0; 
        for (int pile : piles){ 
            if(pile % k == 0){ 
                sum += pile/k; 
            } else {
                sum += (pile / k) + 1; 
            }
        } 
        return sum;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MAX_VALUE;

        int left = 1;
        int right = max;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int time = eatingTimeAtSpeekOf(piles, mid);
            if (time <= h) { 
                max = mid;        
                right = mid - 1;  
            } else { 
                left = mid + 1;   
            }
        }
        return max;
    }
}
