class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int n1 = g.length;
        int n2 = s.length;
        int i = 0,j = 0, c = 0;

        while(i < n1 && j < n2){
            if(g[i] <= s[j]){
                c++;
                i++;
                j++;
            }else if(g[i] > s[j])j++;
        }
        return c;
    }
}
