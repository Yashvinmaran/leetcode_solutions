import java.util.HashSet;

public class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        int maxScore = 0, currentSum = 0;

        while (right < nums.length) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            set.add(nums[right]);
            currentSum += nums[right];
            maxScore = Math.max(maxScore, currentSum);

            right++;
        }

        return maxScore;
    }
}

