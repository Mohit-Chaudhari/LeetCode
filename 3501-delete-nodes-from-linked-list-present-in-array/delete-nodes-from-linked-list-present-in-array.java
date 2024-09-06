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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numbers = new HashSet<>();

        for(int num: nums) {
            numbers.add(num);
        }

        while(head != null && numbers.contains(head.val)) {
            head = head.next;
        }

        ListNode temp = head;
        ListNode prev = head;

        while(temp != null) {
            if(numbers.contains(temp.val)) {
                prev.next = temp.next;
            }
            else {
                prev = temp;
            }
            temp = temp.next;
        }

        return head;
    }
}