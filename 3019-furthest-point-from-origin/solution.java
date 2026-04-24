class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int leftCount = 0;
        int rightCount = 0;
        int spaceCount = 0;

        for (char c : moves.toCharArray()){
            if(c == 'L') leftCount++;
            else if (c == 'R')rightCount++;
            else spaceCount++;
        }

        if(leftCount > rightCount){
            return (leftCount - rightCount) +  spaceCount;
        }

        return rightCount + spaceCount - leftCount;
    }
}
