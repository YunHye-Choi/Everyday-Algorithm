class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if (head == null) return null;
        ListNode temp = head;
        int size = 1;
        while (true) {
            if (temp.next == null) break;
            temp = temp.next;
            size ++;
        }
        int target = size - n;
        if (size == 1) return null;
        if (target == 0){
            head = head.next;
            return head;
        }
        ListNode prev = head;
        for (int i = 1; i < target; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;

    }
}