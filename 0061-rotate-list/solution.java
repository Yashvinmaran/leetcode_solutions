class Solution {
    public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) return head;

    // 1. Find the size and the tail node
    ListNode tail = head;
    int n = 1; 
    while (tail.next != null) {
        tail = tail.next;
        n++;
    }

    // 2. Close the loop (make it circular)
    tail.next = head;

    // 3. Find the new tail: (n - k % n) steps from the old head
    // The new head will be newTail.next
    k = k % n;
    int stepsToNewTail = n - k;
    ListNode newTail = tail; 
    while (stepsToNewTail-- > 0) {
        newTail = newTail.next;
    }

    // 4. Break the loop
    head = newTail.next;
    newTail.next = null;

    return head;
}

}
