class Solution {
    private static int suff(int low, boolean flag){ 
        int len = (int)Math.log10(low) + 1; 
        
        if(low % 10 == 9 && !flag){ 
            len++; 
            flag = true; 
        } 
        
        int[] arr = new int[len]; 
        while(low != 0 && len > 0){ 
            arr[--len] = low % 10; 
            low /= 10; 
        } 
        
        if(flag){ 
            arr[0] = 1; 
            for (int i = 1; i < arr.length; i++){ 
                arr[i] = arr[i - 1] + 1; 
            } 
        } else { 
            for (int i = 0; i < arr.length; i++){ 
                arr[i]++; 
            } 
        } 
        
        int sum = 0; 
        for(int i = 0; i < arr.length; i++){ 
            sum *= 10; 
            sum += arr[i]; 
        } 
        return sum; 
    } 

    private static void fill(int low, int high, List<Integer> ans, boolean flag, int limit){ 
        if(low > high) return; 
        
        low = suff(low, flag); 
        flag = false; 
        
        if(low <= high){ 
            if(low >= limit) ans.add(low); 
            fill(low, high, ans, flag, limit); 
        } 
    } 

    public List<Integer> sequentialDigits(int low, int high) { 
        List<Integer> ans = new LinkedList<>(); 
        boolean flag = true; 
        fill(low, high, ans, flag, low); 
        return ans; 
    } 
}

