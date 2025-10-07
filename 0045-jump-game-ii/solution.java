class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int curr = 0, jumps = 0, dist = 0;
        for(int i = 0;i<n;i++){
            dist = Math.max(dist, i + nums[i]);
            if(i == curr){
                jumps++;
                curr = dist;
                if(curr >= n-1) return jumps;
            }
        }
        System.gc();
        return jumps;
    }
}
