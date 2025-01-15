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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Deque<TreeNode> q = new LinkedList<>();
        q.addFirst(root);
        boolean reverse = false;

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> cl = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                if(reverse) {
                    TreeNode node = q.pollLast();
                    cl.add(node.val);

                    if(node.right != null) q.addFirst(node.right);
                    if(node.left != null) q.addFirst(node.left);
                } else {
                    TreeNode node = q.pollFirst();
                    cl.add(node.val);

                    if(node.left != null) q.addLast(node.left);
                    if(node.right != null) q.addLast(node.right);
                }
            }
            reverse = !reverse;
            result.add(cl);
        }

        return result;
    }
}