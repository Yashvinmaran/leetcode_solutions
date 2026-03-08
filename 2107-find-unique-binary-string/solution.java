class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            set.add(nums[i]);
        }

        int start = (int)Math.pow(2,n-1);
        int end = (int)Math.pow(2,n);
        
        while(start < end){
            String s = Integer.toBinaryString(start);
            if(!set.contains(s))return s;
            start++;
        }
        return String.format("%" + n + "s", "").replace(' ', '0');
    }
}
