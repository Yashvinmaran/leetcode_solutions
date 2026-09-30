class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char c : tasks)
            freq[c - 'A']++;

        Arrays.sort(freq);
        int maxFreq = freq[25];
        int gap = maxFreq - 1;
        int idolSlots = gap * n;

        for (int i = 24; i >= 0; i--) {
            idolSlots -= Math.min(freq[i], gap);
        }

        if (idolSlots > 0) {
            return (tasks.length + idolSlots);
        }

        return tasks.length;
    }
}
