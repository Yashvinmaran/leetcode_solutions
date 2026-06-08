class Solution {

    public int[] pivotArray(int[] arr, int pivotValue) {
        int n = arr.length;
        int[] result = new int[n];
        
        // Three independent pointers to fill the result array
        int lessPtr = 0;
        int equalPtr = 0;
        int greaterPtr = 0;

        // Step 1: Count how many elements are strictly smaller or equal to the pivot.
        // This calculates exactly where each section should start in the new array.
        for (int num : arr) {
            if (num < pivotValue) {
                equalPtr++; // Shifts the start of the 'equal' section
                greaterPtr++; // Shifts the start of the 'greater' section
            } else if (num == pivotValue) {
                greaterPtr++; // Shifts the start of the 'greater' section
            }
        }

        // Step 2: Fill the result array sequentially to maintain original relative order.
        for (int num : arr) {
            if (num < pivotValue) {
                result[lessPtr++] = num;
            } else if (num == pivotValue) {
                result[equalPtr++] = num;
            } else {
                result[greaterPtr++] = num;
            }
        }

        return result;
    }
}

