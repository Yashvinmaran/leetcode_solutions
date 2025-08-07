class Solution {
    int firstMin;
    long secondMin=Long.MAX_VALUE ;

    public int findSecondMinimumValue(TreeNode root) {
        if(root==null) return -1;
        firstMin=root.val;
        secondMin(root);
        
        return (secondMin==Long.MAX_VALUE) ? -1:(int) secondMin;
    }

    public void secondMin(TreeNode root){
        if(root==null) return;
        if(root.val<secondMin && root.val>firstMin){
            secondMin=root.val;
        }
        secondMin(root.left);
        secondMin(root.right);
    }
}
