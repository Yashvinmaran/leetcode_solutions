class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a Min-Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int n : nums) {
            pq.add(n);
            // Keep the heap size strictly at k
            if (pq.size() > k) {
                pq.poll(); // Remove the smallest element
            }
        }
        
        // The root of the Min-heap is now the kth largest element
        return pq.peek();
    }
}

