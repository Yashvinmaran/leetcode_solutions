class Solution {
    public boolean isPalindromic(String s) {
        int n = s.length();
        // Total number of bits in the combined binary string
        int totalBits = n * 8; 
        
        int left = 0;
        int right = totalBits - 1;
        
        while (left < right) {
            // Find which character and which bit index from the left
            int leftCharIdx = left / 8;
            int leftBitIdx = left % 8; // 0 means MSB (most significant bit), 7 means LSB
            
            // Find which character and which bit index from the right
            int rightCharIdx = right / 8;
            int rightBitIdx = right % 8;
            
            // Extract the ASCII value of the characters
            int leftCharVal = s.charAt(leftCharIdx);
            int rightCharVal = s.charAt(rightCharIdx);
            
            // Extract the specific bit (8-bit representation, so bit index is 7 - bitIdx)
            int leftBit = (leftCharVal >> (7 - leftBitIdx)) & 1;
            int rightBit = (rightCharVal >> (7 - rightBitIdx)) & 1;
            
            // If the bits don't match, it's not a palindrome
            if (leftBit != rightBit) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}

