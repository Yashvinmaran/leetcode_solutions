class Solution {
    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] < 0) return false;
        
        if (arr[start] == 0) return true;

        arr[start] = -arr[start];

        int jump = Math.abs(arr[start]);
        boolean found = canReach(arr, start - jump) || canReach(arr, start + jump);


        return found;
    }
}

