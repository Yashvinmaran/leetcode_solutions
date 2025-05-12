import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> resultSet = new TreeSet<>();
        int[] freq = new int[10];
        for (int d : digits) freq[d]++;

        for (int num = 100; num <= 999; num += 2) {
            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            int[] tempFreq = new int[10];
            tempFreq[a]++;
            tempFreq[b]++;
            tempFreq[c]++;

            boolean valid = true;
            for (int d = 0; d <= 9; d++) {
                if (tempFreq[d] > freq[d]) {
                    valid = false;
                    break;
                }
            }

            if (valid) resultSet.add(num);
        }

        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) result[i++] = num;
        return result;
    }
}

