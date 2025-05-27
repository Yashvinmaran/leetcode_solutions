class Solution {
    public int differenceOfSums(int n, int m) {
        int count = n / m;
return (((n * (n + 1)) / 2) - ((count * (m + (count * m))) / 2)) - ((count * (m + (count * m))) / 2);
    }
}

