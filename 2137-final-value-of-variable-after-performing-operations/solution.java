class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (var s : operations){
            if(s.equals("++X"))x++;
            else if(s.equals("X++"))x++;
            else if(s.equals("--X"))x--;
            else if(s.equals("X--"))x--;
        }
        return x;
    }
}
