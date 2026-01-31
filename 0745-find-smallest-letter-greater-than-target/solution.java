class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // int diff = 0;
        // int diff_positive = 0;
        if(letters[letters.length - 1] <= target)return letters[0];
        for (char letter : letters){
            if(letter > target)return letter;
        }
        return letters[letters.length - 1];
    }
}
