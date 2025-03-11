class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
       int first =-1,last =-1;
       for(int i=0;i<nums.size();i++)
       {
        if(nums[i]==target)
        {
            if(first==-1){first=i;}
            else{
                last=i;
            }
        }
       }

       if(last == -1){
        last = first;
       }
       return {first, last};
    }
};

