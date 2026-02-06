class KthLargest {
    int k;
    int[] minHeap;
    int size;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new int[k];
        size = 0;
        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int num) {
        if(size < k) {
            minHeap[size] = num;
            siftUp(size);
            size++;
        }else {
            if(num > minHeap[0]) {
                minHeap[0] = num;
                siftDown(0);
            }
        }
        return size < k ? -1 : minHeap[0];
    }

    public void siftUp(int index) {
        while(index > 0){
            int parent = (index - 1) / 2;
            if(minHeap[parent] <= minHeap[index]) {
                break;
            }
            swap(parent, index);
            index = parent;
        }
    }

    public void siftDown(int index) {
        while(true) {
            int left = (2 * index) + 1;
            int right = (2 * index) + 2;
            int smallest = index;
            if(left < size && minHeap[left] < minHeap[smallest]) {
                smallest = left; 
            }
            if(right < size && minHeap[right] < minHeap[smallest]) {
                smallest = right;
            }
            if(smallest == index){
                break;
            }
            swap(smallest, index);
            index = smallest;
        }
    }

    public void swap(int a, int b) {
        int temp = minHeap[a];
        minHeap[a] = minHeap[b];
        minHeap[b] = temp;
    }
}
