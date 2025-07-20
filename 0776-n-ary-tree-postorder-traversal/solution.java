class Solution {
    private void helper(Node root, List<Integer>list){
        if(root == null)return;

        for(Node child : root.children){
            helper(child, list);
        }
        list.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        List<Integer>list = new ArrayList<>();
        helper(root, list);
        return list;
    }
}
