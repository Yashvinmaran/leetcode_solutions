import java.util.HashMap;

class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        int total = 0;

        for (int key : map.keySet()) {
            int groupSize = key + 1;
            int freq = map.get(key);
            
            int groups = (int) Math.ceil((double) freq / groupSize);
            
            total += groups * groupSize;
        }

        return total;
    }
}

