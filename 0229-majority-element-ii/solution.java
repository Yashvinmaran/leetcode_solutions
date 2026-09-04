class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();

        int curr1 = Integer.MIN_VALUE;
        int curr2 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int cnt2 = 0;

        for (int i = 0; i < nums.length; i++){
            if(cnt1 == 0 && nums[i] != curr2){
                curr1 = nums[i];
                cnt1++;
            }
            else if(nums[i] == curr1)cnt1++;
            
            else if(cnt2 == 0 && nums[i] != curr1){
                curr2 = nums[i];
                cnt2++;
            }
            else if(nums[i] == curr2)cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }

        int c1 = 0, c2 = 0;
        for (int i = 0; i < nums.length; i++){
            if(curr1 == nums[i])c1++;
            if(curr2 == nums[i])c2++;
        }
        int mini = (int)(nums.length / 3) + 1;
        if(c1 >= mini)ans.add(curr1);
        if(c2 >= mini)ans.add(curr2);

        Collections.sort(ans);
        return ans;
    }
}
