/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            long cs = 0;

            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                cs += node.val;
            }

            System.out.println(cs);
            pq.add(cs);
            if(pq.size() > k) pq.remove();
        }
        if(pq.size() < k) return -1;
        return pq.remove();
    }
}