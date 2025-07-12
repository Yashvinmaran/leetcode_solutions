class MyHashSet {
    class Node {
        int key;
        Node next;
        
        Node(int key) {
            this.key = key;
        }
    }

    private Node head; // start of the linked list

    public MyHashSet() {
        head = null;
    }

    public void add(int key) {
        if (contains(key)) return; // avoid duplicates

        Node newNode = new Node(key);
        newNode.next = head;
        head = newNode;
    }

    public void remove(int key) {
        Node curr = head, prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    head = curr.next; // remove head
                } else {
                    prev.next = curr.next; // remove middle or tail
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.key == key) return true;
            temp = temp.next;
        }
        return false;
    }
}

