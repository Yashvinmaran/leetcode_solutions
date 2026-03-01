class Solution {
    public int minPartitions(String n) {
        char ans = '1';
        for (char c : n.toCharArray()){
            ans = ans < c ? c : ans;
        }
        return (ans - '0');
    }
}
