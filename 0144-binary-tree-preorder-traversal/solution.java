// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {

//         ArrayList<Integer> ans = new ArrayList<>();

//         if(root == null) return ans;

//         Stack<TreeNode> st = new Stack<>();

//         st.push(root);

//         while(!st.isEmpty()){
//             TreeNode node = st.pop();
//             ans.add(node.val);
//             if(node.right != null) st.push(node.right);
//             if(node.left != null) st.push(node.left);
//         }

//         return ans;
//     }
// }




class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        TreeNode curr = root;

        while(curr != null){
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode leftChild = curr.left;
                while(leftChild.right != null){
                    leftChild = leftChild.right;
                }

                ans.add(curr.val);

                leftChild.right = curr.right;

                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }

        return ans;
    }
}
