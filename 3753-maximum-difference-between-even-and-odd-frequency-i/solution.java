class Solution {
    public int maxDifference(String s) {
        char []st = new char[s.length()];
        st = s.toCharArray();
        TreeMap<Character,Integer>mp = new TreeMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (char ch : st){
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        for(char key : mp.keySet()){
            if(mp.get(key) < min && mp.get(key)%2 == 0) min = mp.get(key);
            if(mp.get(key) > max && mp.get(key)%2 != 0) max = mp.get(key);
        }
        return max - min;
    }
}
