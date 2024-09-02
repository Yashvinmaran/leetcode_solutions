class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        # MCMXCIV
        numerals = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000
        }

        romanInt = 0
        n = len(s) - 1

        for i in range(n, -1, -1):
            curr = s[i]
            prev = i + 1

            if prev > n:
                romanInt = numerals[curr]
            elif numerals[curr] < numerals[s[prev]]:
                romanInt -= numerals[curr]
            else:
                romanInt += numerals[curr]

        return romanInt


