class Solution {

    private boolean isWithinTwoEdits(String s1, String s2) {
        if (s1.length() != s2.length()) return false; 
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff <= 2;
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (String q : queries) {
            for (String d : dictionary) {
                if (isWithinTwoEdits(q, d)) {
                    ans.add(q);
                    break; 
                }
            }
        }
        return ans;
    }
}

