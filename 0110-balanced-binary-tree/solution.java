// // By the help of bfs
// class Solution {

//     private static int height(TreeNode root){
//         if(root == null) return 0;

//         return Math.max(height(root.left), height(root.right)) + 1;
//     }

//     public boolean isBalanced(TreeNode root) {
//         if(root == null) return true;

//         Queue<TreeNode> qu = new ArrayDeque<>();
//         qu.offer(root);

//         while(!qu.isEmpty()){

//             TreeNode node = qu.poll();

//             if(Math.abs((height(node.left) - height(node.right))) > 1) return false;

//             if(node.left != null) qu.offer(node.left);
//             if(node.right != null) qu.offer(node.right);
//         }

//         return true;
//     }
// }

class Solution {

    private static int dfs(TreeNode root){
        if(root == null)return 0;

        int left = dfs(root.left);
        if(left == -1) return -1;

        int right = dfs(root.right);
        if(right == -1) return -1;

        if(Math.abs(right - left) > 1) return -1;

        return Math.max(left, right) + 1;
    }
    

    public boolean isBalanced(TreeNode root) {

        if(root == null) return true;

        if(dfs(root) == -1)return false;

        return true;
    }
}
