class Solution {
    int a = 1, e = 1, i = 1, o = 1, u = 1;
    private void increament(){
        a = a + e + i + o + u;
        e = e + i + o + u;
        i = i + o + u;
        o = o + u;
    }
    public int countVowelStrings(int n) {
        for (int i = 1; i < n; i++){
            increament();
        }
        return a + e + i + o + u;
    }
}
