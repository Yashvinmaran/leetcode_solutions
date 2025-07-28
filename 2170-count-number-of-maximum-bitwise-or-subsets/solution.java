class Solution {

    private void helper(int[] nums, List<List<Integer>> subsets, List<Integer> result, int i){
        if(i == nums.length){
            subsets.add(new ArrayList<>(result));
            return;
        }
        result.add(nums[i]);
        helper(nums, subsets, result, i + 1);
        result.remove(result.size() - 1);
        helper(nums, subsets, result, i + 1);
    }

    private int findMax(List<Integer> set){
        int or = 0;
        for (int num : set){
            or |= num;
        }
        return or;
    }

    private int checkMaxOr(List<List<Integer>> subsets){
        int max = 0;
        for (List<Integer> set : subsets){
            max = Math.max(findMax(set), max);
        }
        return max;
    }

    private int countMaxOr(List<List<Integer>> subsets, int max){
        int count = 0;
        for (List<Integer> set : subsets){
            if (findMax(set) == max){
                count++;
            }
        }
        return count;
    }

    public int countMaxOrSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        helper(nums, subsets, result, 0);

        int maxOr = checkMaxOr(subsets);
        return countMaxOr(subsets, maxOr);
    }
}

