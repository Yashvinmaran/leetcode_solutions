class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq_arr = new int[26];
        Set<Character> set = new HashSet<>();
        set.add('b');
        set.add('a');
        set.add('l');
        set.add('o');
        set.add('n');

        for (char c : text.toCharArray()){
            freq_arr[c - 'a']++;
        }

       int max = Math.min(freq_arr['l' - 'a'],freq_arr['o' - 'a']);
       max /= 2;
        

        for (var c : set){
            max = Math.min(max, freq_arr[c-'a']);
        }

        return max;
    }
}
