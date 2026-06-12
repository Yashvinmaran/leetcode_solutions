class Solution {
    public int numDifferentIntegers(String word) {
        // 1. Replace all lowercase letters with a single space
        String replace = word.replaceAll("[a-z]+", " ");
        Set<String> set = new HashSet<>();

        for (String rep : replace.split(" ")) {
            // 2. Skip empty strings caused by consecutive spaces or edges
            if (!rep.isEmpty()) {
                // 3. Remove leading zeros using regex. 
                // "007" becomes "7". "000" becomes "0".
                String cleanedNum = rep.replaceAll("^0+", "");
                
                // 4. If the string becomes empty (it was all zeros), make it "0"
                if (cleanedNum.isEmpty()) {
                    cleanedNum = "0";
                }
                
                set.add(cleanedNum);
            }
        }

        return set.size();
    }
}
