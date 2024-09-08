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
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        int len = 0;
        ListNode curr = head;
        ListNode[] result = new ListNode[k];

        // calculate the length of the linked list
        while(curr != null) {
            curr = curr.next;
            len++;
        }

        int bucketNodesCount = len / k;
        int remainderNodesCount = len % k;
        curr = head;
        ListNode prev = null;

        for(int i = 0; curr != null && i < k; i++) {
            result[i] = curr;

            // separate the bucket nodes
            for(int count = 0; count < bucketNodesCount + (remainderNodesCount > 0 ? 1: 0); count++) {
                prev = curr;
                curr = curr.next;
            }

            remainderNodesCount--;

            if(prev != null) prev.next = null;
        }

        return result;

    }
}