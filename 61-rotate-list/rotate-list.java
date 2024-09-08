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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null) return head;
        
        int len = 1;
        ListNode curr = head;

        // count length of linked list
        while(curr.next != null) {
            curr = curr.next;
            len++;
        }

        // calculate the rotation
        int rotation = len - (k % len);
        curr.next = head;

        for(int i = 0; i < rotation; i++) {
            curr = curr.next;
        }

        head = curr.next;
        curr.next = null;

        return head;
    }
}