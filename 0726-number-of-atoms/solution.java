class Solution {
    public String countOfAtoms(String formula) {

        int n = formula.length();

        Map<String, Integer> map = new TreeMap<>();

        Stack<Integer> multiplierStack = new Stack<>();

        int multiplier = 1;

        int num = 0;
        int base = 1;

        String curr = "";

        for (int i = n - 1; i >= 0; i--) {

            char ch = formula.charAt(i);

            // lowercase letters
            if (ch >= 'a' && ch <= 'z') {
                curr = ch + curr;
            }

            // digits
            else if (Character.isDigit(ch)) {
                num = (ch - '0') * base + num;
                base *= 10;
            }

            // closing bracket
            else if (ch == ')') {

                int val = (num == 0) ? 1 : num;

                multiplier *= val;

                multiplierStack.push(val);

                num = 0;
                base = 1;
            }

            // opening bracket
            else if (ch == '(') {

                multiplier /= multiplierStack.pop();

                num = 0;
                base = 1;
            }

            // uppercase letter => complete atom
            else {

                curr = ch + curr;

                int val = (num == 0) ? 1 : num;

                map.put(curr,
                        map.getOrDefault(curr, 0) + val * multiplier);

                curr = "";

                num = 0;
                base = 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String key : map.keySet()) {

            sb.append(key);

            int count = map.get(key);

            if (count > 1) {
                sb.append(count);
            }
        }

        return sb.toString();
    }
}
