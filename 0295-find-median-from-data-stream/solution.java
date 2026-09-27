class MedianFinder {

    PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(leftMaxHeap.isEmpty() || leftMaxHeap.peek() > num){
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }

        if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        } 
        else if (leftMaxHeap.size() > rightMinHeap.size() + 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (leftMaxHeap.size() > rightMinHeap.size()) {
            return leftMaxHeap.peek();
        }

        return ((leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0);
    }
}

