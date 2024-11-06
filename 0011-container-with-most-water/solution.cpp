class Solution {
public:
    int maxArea(vector<int>& height) {
        int Area = 0;
        int maximum_total_area = 0;
        int left = 0, right = height.size()-1;
        while (left < right){
            Area = (min(height[left], height[right]))*(right - left);
            maximum_total_area = max(Area, maximum_total_area);
            if(height[left]<height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return maximum_total_area;
    }
};
