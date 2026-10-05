// class Solution {
//     public static int cnt = 0;
//     public static TreeNode small = null;

//     private static void helper(TreeNode root, int k) {
//         if (root == null) return;
        
//         helper(root.left, k);
        
//         cnt++;
//         if (cnt == k) {
//             small = root;
//             return;
//         }
        
//         helper(root.right, k);
//     }

//     public int kthSmallest(TreeNode root, int k) {
//         cnt = 0;
//         small = null;
//         helper(root, k);
//         return small != null ? small.val : -1;
//     }
// }





class Solution {

    public int kthSmallest(TreeNode root, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        int cnt = 0;

        TreeNode curr = root;

        while(curr != null){
            TreeNode leftChild = curr.left;

            if(curr.left == null){
                cnt++;
                if(cnt == k)return curr.val;
                curr = curr.right;
                
            }else{

                while(leftChild.right != null){
                    leftChild = leftChild.right;
                }

                leftChild.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }

        return -1;
    }
}
