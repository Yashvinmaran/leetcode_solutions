// class Solution {

//     private static void dfs(TreeNode root, int level, List<List<Integer>> ans){
//         if(root == null){
//             return;
//         }

//         if(level == ans.size()){
//             ans.add(new ArrayList<>());
//         }

//         ans.get(level).add(root.val);
//         dfs(root.left, level + 1, ans);
//         dfs(root.right, level + 1, ans);
       
//     }

//     public List<List<Integer>> levelOrder(TreeNode root) {

//         List<List<Integer>> ans = new ArrayList<>();

//         dfs(root, 0, ans);

//         return ans;
//     }
// }




// By another method help's of BFS

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if(root == null)return ans;

        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);

        while(!qu.isEmpty()){
            
            List<Integer> curr = new ArrayList<>();
            int size = qu.size();

            for (int i = 0; i < size; i++){
                TreeNode node = qu.poll();
                curr.add(node.val);

                if(node.left != null) qu.add(node.left);
                if(node.right != null) qu.add(node.right);
            }

            ans.add(curr);
        }

        return ans;
    }
}
