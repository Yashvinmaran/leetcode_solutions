class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedHashMap<Character, String> mpp = new LinkedHashMap<>();
        mpp.put('2', "abc");
        mpp.put('3', "def");
        mpp.put('4', "ghi");
        mpp.put('5', "jkl");
        mpp.put('6', "mno");
        mpp.put('7', "pqrs");
        mpp.put('8', "tuv");
        mpp.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        result.add(""); // starting point

        for (int i = 0; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            String letters = mpp.get(digit);
            List<String> temp = new ArrayList<>();

            for (String combination : result) {
                for (int j = 0; j < letters.length(); j++) {
                    temp.add(combination + letters.charAt(j));
                }
            }

            result = temp;
        }
        return result;
    }
}

