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

    // calculate GCD using eucledian algorithm
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) { 
        if(head.next == null) return head;

        // create GCD node and set the next node.
        ListNode gcdNode = new ListNode(gcd(head.val, head.next.val), insertGreatestCommonDivisors(head.next));
        head.next = gcdNode;

        return head;
    }
}