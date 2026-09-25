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
    private final int capacity;
    private final Map<Integer, Node> map;
    
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        moveToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {

            Node node = map.get(key);
            node.val = value;
            moveToTail(node);
        } else {

            if (map.size() == capacity) {
                Node lruNode = head.next;
                removeNode(lruNode);
                map.remove(lruNode.key);
            }
            
            Node newNode = new Node(key, value);
            addToTail(newNode);
            map.put(key, newNode);
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToTail(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void moveToTail(Node node) {
        removeNode(node);
        addToTail(node);
    }
}

