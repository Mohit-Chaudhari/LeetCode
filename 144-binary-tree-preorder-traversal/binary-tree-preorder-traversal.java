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

    private void travel(TreeNode node, List<Integer> arr) {
        if(node == null) return;

        arr.add(node.val);
        if(node.left != null) travel(node.left, arr);
        if(node.right != null) travel(node.right, arr);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        travel(root, arr);
        return arr;
    }
}