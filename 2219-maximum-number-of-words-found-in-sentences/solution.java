class Solution {
    public int count(String sentence){
        int cnt = 0;
        if(sentence.length() > 0)cnt++;
        for(char c : sentence.toCharArray()){
            if(c == ' ')cnt++;
        }
        return cnt;
    }
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences){
            max = Math.max(max, count(sentence));
        }
        return max;
    }
}
