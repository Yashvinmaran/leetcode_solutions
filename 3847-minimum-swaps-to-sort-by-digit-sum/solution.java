class Solution {
    
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    static class Element implements Comparable<Element> {
        int value;
        int digitSum;
        int originalIndex;

        Element(int value, int digitSum, int originalIndex) {
            this.value = value;
            this.digitSum = digitSum;
            this.originalIndex = originalIndex;
        }

        @Override
        public int compareTo(Element other) {
            if (this.digitSum != other.digitSum) {
                return Integer.compare(this.digitSum, other.digitSum);
            }
            return Integer.compare(this.value, other.value);
        }
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        Element[] elements = new Element[n];
        
        for (int i = 0; i < n; i++) {
            elements[i] = new Element(nums[i], getDigitSum(nums[i]), i);
        }

        Arrays.sort(elements);

        boolean[] visited = new boolean[n];
        int totalSwaps = 0;

        for (int i = 0; i < n; i++) {

            if (visited[i] || elements[i].originalIndex == i) {
                continue;
            }

            int cycleSize = 0;
            int curr = i;
            
            while (!visited[curr]) {
                visited[curr] = true;
                curr = elements[curr].originalIndex;
                cycleSize++;
            }

            if (cycleSize > 1) {
                totalSwaps += (cycleSize - 1);
            }
        }

        return totalSwaps;
    }
}

