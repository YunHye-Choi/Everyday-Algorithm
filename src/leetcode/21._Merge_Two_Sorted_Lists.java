/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ln1 = list1;
        ListNode ln2 = list2;
        ListNode ans = new ListNode();
        if (ln1 == null && ln2 == null) return null;
        if (ln1 == null) return ln2;
        if (ln2 == null) return ln1;

        if (list1.val < list2.val) {
            ans = new ListNode(ln1.val);
            ln1 = ln1.next;
        } else {
            ans = new ListNode(ln2.val);
            ln2 = ln2.next;
        }
        ListNode ansHead = ans;
        while (true) {
            if (ln1 == null) {
                ans.next = ln2;
                break;
            } 
            else if (ln2 == null) {
                ans.next = ln1;
                break;
            }
            else if (ln1.val < ln2.val) {
                ans.next = new ListNode(ln1.val);
                ln1 = ln1.next; 
            } else {
                ans.next = new ListNode(ln2.val);
                ln2 = ln2.next; 
            }
            ans = ans.next;
        }
        return ansHead;
    }
}