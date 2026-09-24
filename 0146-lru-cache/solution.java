class Node { 
    int key; 
    int val; 
    Node next; 
    Node prev; 
    
    Node() {} 
    Node(int key, int val) { 
        this.key = key;
        this.val = val; 
    } 
} 

class LRUCache { 
    private int capacity; 
    private Map<Integer, Node> map = new HashMap<>(); 
    private Node head = null; 
    private Node tail = null; 

    public LRUCache(int capacity) { 
        this.capacity = capacity; 
    } 

    public int get(int key) { 
        if (!map.containsKey(key)) return -1; 
        
        Node node = map.get(key);
        moveToTail(node);
        return node.val; 
    } 

    public void put(int key, int value) { 
        if (map.containsKey(key)) {
          
            Node node = map.get(key);
            node.val = value;
            moveToTail(node);
            return;
        }

       
        if (map.size() == capacity) {
            evictPage();
        }

        Node newNode = new Node(key, value);
        addToTail(newNode);
        map.put(key, newNode);
    }

  

    private void addToTail(Node node) {
        if (tail == null) { 
            head = tail = node; 
        } else { 
            tail.next = node; 
            node.prev = tail; 
            tail = node; 
        } 
    }

    private void removeNode(Node node) {
        if (node == head) head = head.next;
        if (node == tail) tail = tail.prev;
        
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        
        node.next = null;
        node.prev = null;
    }

    private void moveToTail(Node node) {
        if (node == tail) return;
        removeNode(node);
        addToTail(node);
    }

    private void evictPage() {
        if (head == null) return;
        map.remove(head.key); 
        removeNode(head);     
    }
}

