class Solution {

    private static final String[] ORDER = {
        "electronics", "grocery", "pharmacy", "restaurant"
    };

    private boolean isValid(String s) {
        if (s == null || s.isEmpty()) return false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }

    public List<String> validateCoupons(String[] code,
                                        String[] businessLine,
                                        boolean[] isActive) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < code.length; i++) {
            if (isActive[i] && isValid(code[i])) {
                map.computeIfAbsent(businessLine[i], k -> new ArrayList<>())
                   .add(code[i]);
            }
        }

        List<String> result = new ArrayList<>();

        for (String biz : ORDER) {
            List<String> group = map.get(biz);
            if (group != null) {
                Collections.sort(group);
                result.addAll(group);
            }
        }

        return result;
    }
}

