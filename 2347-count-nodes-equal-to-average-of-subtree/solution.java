class Solution { 

    static class Pair<K, V> { 
        K sum; 
        V cnt; 
        Pair(K sum, V cnt) { 
            this.sum = sum; 
            this.cnt = cnt; 
        } 
    } 
    
    public static int result; 
    

    private static Pair<Integer, Integer> solve(TreeNode root) { 
        if (root == null) return new Pair<>(0, 0); 
        
        Pair<Integer, Integer> left = solve(root.left); 
        Pair<Integer, Integer> right = solve(root.right); 
        
        int sum = left.sum + right.sum + root.val; 
        int cnt = left.cnt + right.cnt + 1; 
        
        int avg = sum / cnt; 
        if (avg == root.val) result += 1; 
        
        return new Pair<>(sum, cnt); 
    } 
    
    public int averageOfSubtree(TreeNode root) { 
        result = 0; 
        solve(root); 
        return result; 
    } 
}

