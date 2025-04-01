class Solution {
    public int findPairs(int[] nums, int k) {
        if(k < 0)return 0;

        HashMap<Integer, Integer>mpp = new HashMap<>();

        for (int n : nums){
            mpp.put(n, mpp.getOrDefault(n, 0) + 1);
        }

        int count = 0;

        for(int key : mpp.keySet()){
            if(k == 0){
                if(mpp.get(key) > 1)count++; 
            }else{
                if(mpp.containsKey(key + k))count++;
            }
        }
        return count;
    }
}

