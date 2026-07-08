class Solution { 
    private static int calculate(int[] piles, int k){ 
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
        int low = 1; 
        int high = Integer.MAX_VALUE; 
     
        
        int ans = high; 
        while(low <= high){ 
            int mid = low + (high - low) / 2; 
            int check = calculate(piles, mid); 
            
            if(check <= h){ 
                ans = mid; 
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        } 
        return ans; 
    } 
}

