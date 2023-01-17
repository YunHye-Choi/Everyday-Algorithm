// https://leetcode.com/problems/add-two-numbers/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 정답 풀이
        class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode result = node;
        int sum  =0;
        while (l1 != null || l2 != null || sum > 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;     
            }

            if (l2 != null) {
                sum +=  l2.val;
                l2 = l2.next;
            }
            
            node.next = new ListNode(sum % 10);
            sum /= 10;

            node = node.next;
        }
        return result.next;
    }
}

        // 옛 풀이
    //     Long ans = 0L;
    //     String s1 = "", s2 = "";
    //     while (true) {
    //         if (l1 == null) {
    //             break;
    //         }
    //         System.out.println(l1.val);
    //         s1 += l1.val;
    //         l1 = l1.next;
    //     }
    //     StringBuffer sb = new StringBuffer(s1);
    //     s1 = sb.reverse().toString();

    //     while (true) {
    //         if (l2 == null) {
    //             break;
    //         }
    //         System.out.println(l2.val);
    //         s2 += l2.val;
    //         l2 = l2.next;
    //     }
    //     sb = new StringBuffer(s2);
    //     s2 = sb.reverse().toString();

    //     System.out.println(s1);
    //     System.out.println(s2);

    //     Long i1 = Long.parseLong(s1);
    //     Long i2 = Long.parseLong(s2);
    //     ans = i1 + i2;

    //     String ansStr = ans +"";

    //     sb = new StringBuffer(ansStr);
    //     ansStr = sb.reverse().toString();

    //     ListNode ansLn = new ListNode(Integer.parseInt(ansStr.charAt(0)+""));
    //     ListNode firstLn = ansLn;
    //     for (int i = 1; i < ansStr.length(); i++) {
    //         ansLn.next = new ListNode(Integer.parseInt(ansStr.charAt(i)+""), null);
    //         if (i < ansStr.length()) {
    //             ansLn = ansLn.next;
    //         }
    //     }
    //     return firstLn;
    // }
}