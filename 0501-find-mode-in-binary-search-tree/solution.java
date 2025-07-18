class Solution {

   private void helper(TreeNode root, Map<Integer,Integer>map){
    if(root == null)return;
    map.put(root.val, map.getOrDefault(root.val, 0) + 1);
    helper(root.left, map);
    helper(root.right, map);
   }

    public int[] findMode(TreeNode root) {
        Map<Integer,Integer>map = new HashMap<>();
        helper(root, map);
        int maxi = 0;
        for (int key : map.keySet()){
            maxi = Math.max(maxi, map.get(key));
        }
        int c = 0;
        for (int key : map.keySet()){
            if(map.get(key) == maxi)c++;
        }
        int[] arr = new int[c];
        c = 0;
        for (int key : map.keySet()){
            if(map.get(key) == maxi)arr[c++] = key;
        }
        return arr;
    }
}
