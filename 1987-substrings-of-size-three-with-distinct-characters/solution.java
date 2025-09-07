import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 0; i <= s.length() - 3; i++) {
            String str = s.substring(i, i + 3);
            if (goodString(str)) count++;
        }
        return count;
    }

    private boolean goodString(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        return set.size() == 3;
    }
}

