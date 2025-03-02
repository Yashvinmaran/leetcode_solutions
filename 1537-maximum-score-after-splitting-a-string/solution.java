class Solution {
    public int maxScore(String s) {
        int totalOnes = 0, leftZeros = 0, maxScore = 0;
        int n = s.length();
        
        for (char ch : s.toCharArray()) {
            if (ch == '1') totalOnes++;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                totalOnes--;
            }
            maxScore = Math.max(maxScore, leftZeros + totalOnes);
        }

        return maxScore;
    }
}

