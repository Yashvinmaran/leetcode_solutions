// // Brute Force O(n * n)

// class Solution {

    
//     private int countPathsFromNode(TreeNode root, long target, long currentSum) {
//         if (root == null) return 0;
        
//         currentSum += root.val;
//         int count = 0;
        
//         if (currentSum == target) {
//             count++;
//         }
        
//         count += countPathsFromNode(root.left, target, currentSum);
//         count += countPathsFromNode(root.right, target, currentSum);
        
//         return count;
//     }

//     public int pathSum(TreeNode root, int targetSum) {
//         if (root == null) return 0;
        
//         int pathsFromRoot = countPathsFromNode(root, targetSum, 0);
        
//         int pathsFromLeft = pathSum(root.left, targetSum);
//         int pathsFromRight = pathSum(root.right, targetSum);
        
//         return pathsFromRoot + pathsFromLeft + pathsFromRight;
//     }
// }





// Optimal O(n)

class Solution {

    int total = 0;

    private void solve(TreeNode root, int tar, HashMap<Long, Integer> map, long sum){
        if(root == null) return;
        
        sum += root.val;
        if(map.containsKey(sum - tar)){
            total += map.get(sum - tar);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        
        solve(root.left, tar, map, sum);
        solve(root.right, tar, map, sum);

        map.put(sum, map.getOrDefault(sum, 0) - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        total = 0;

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        solve(root, targetSum, map, 0L);
        return total;
    }
}

