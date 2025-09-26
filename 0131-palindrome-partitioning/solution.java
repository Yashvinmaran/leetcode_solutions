class Solution {
    private static boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    public static void helper(String s, int idx, List<String> current, List<List<String>> result) {
        if(idx == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = idx; i < s.length(); i++) {
            if(isPalindrome(s, idx, i)) {
                current.add(s.substring(idx, i + 1));

                helper(s, i + 1, current, result);

                current.remove(current.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result);
        return result;
    }
}

