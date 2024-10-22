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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0, maxi = Integer.MIN_VALUE, count = 0;
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            int currmax = 0;
        
            for(int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                currmax += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }

            count++;
            if(currmax > maxi) {
                level = count;
                maxi = currmax;
            }
        }

        return level;
    }
}