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

    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] matrix = new int[m][n];
        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while(top <= bottom && left <= right) {

            System.out.println("Left to Right");
            // step 1: Left to Right > top++;
            for(int i = left; i <= right; i++) {
                if(head != null) {
                    // System.out.println(head.val);
                    matrix[top][i] = head.val;
                    head = head.next;
                }
                else matrix[top][i] = -1;
                System.out.println("matrix: " + matrix[top][i]);
            } 
            top++;

            System.out.println("Top to Bottom");
            // step 2: top to bottom > right--;
            for(int i = top; i <= bottom; i++) {
                if(head != null) {
                    matrix[i][right] = head.val;
                    head = head.next;
                } else matrix[i][right] = -1;
                System.out.println("matrix: " + matrix[i][right]);
            }
            right--;

            System.out.println("Right to Left");
            // step 3: right to left > bottom --;
            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                    if(head != null) {
                        matrix[bottom][i] = head.val;
                        head = head.next;
                    } else matrix[bottom][i] = -1;
                    System.out.println("matrix: " + matrix[bottom][i]);
                }
                bottom--;
            }

            System.out.println("Bottom to Top");
            // step 4: bottom to top > left++;
            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    if(head != null) {
                        matrix[i][left] = head.val;
                        head = head.next;
                    } else matrix[i][left] = -1;
                    System.out.println("matrix: " + matrix[i][left]);
                }
                left++;
            }
        }

        return matrix;
    }
}