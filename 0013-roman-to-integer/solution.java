class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length) {
                if (chars[i] == 'I' && chars[i + 1] == 'V') {
                    result += 4;
                    i++;
                } else if (chars[i] == 'I' && chars[i + 1] == 'X') {
                    result += 9;
                    i++;
                } else if (chars[i] == 'X' && chars[i + 1] == 'L') {
                    result += 40;
                    i++;
                } else if (chars[i] == 'X' && chars[i + 1] == 'C') {
                    result += 90;
                    i++;
                } else if (chars[i] == 'C' && chars[i + 1] == 'D') {
                    result += 400;
                    i++;
                } else if (chars[i] == 'C' && chars[i + 1] == 'M') {
                    result += 900;
                    i++;
                } else {
                    switch (chars[i]) {
                        case 'M':
                            result += 1000;
                            break;
                        case 'D':
                            result += 500;
                            break;
                        case 'C':
                            result += 100;
                            break;
                        case 'L':
                            result += 50;
                            break;
                        case 'X':
                            result += 10;
                            break;
                        case 'V':
                            result += 5;
                            break;
                        case 'I':
                            result += 1;
                            break;
                    }
                }
            } else {
                switch (chars[i]) {
                    case 'M':
                        result += 1000;
                        break;
                    case 'D':
                        result += 500;
                        break;
                    case 'C':
                        result += 100;
                        break;
                    case 'L':
                        result += 50;
                        break;
                    case 'X':
                        result += 10;
                        break;
                    case 'V':
                        result += 5;
                        break;
                    case 'I':
                        result += 1;
                        break;
                }
            }
        }
        return result;
    }
}
