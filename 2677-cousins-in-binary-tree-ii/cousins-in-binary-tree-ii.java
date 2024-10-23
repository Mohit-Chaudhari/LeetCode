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

    private void levelSum(TreeNode root, List<Integer> list) {
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            int levelSum = 0;

            while(size-- > 0) {
                TreeNode node = q.remove();
                levelSum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            list.add(levelSum);
        }
    }

    private void assign(TreeNode root, List<Integer> list) {
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        root.val = 0;
        int index = 1;

        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                TreeNode node = q.remove();
                int leftNode = node.left != null ? node.left.val : 0;
                int rightNode = node.right != null ? node.right.val : 0;
                int siblingSum = leftNode + rightNode;

                if(node.left != null) {
                    node.left.val = list.get(index) - siblingSum;
                    q.offer(node.left);
                }

                if(node.right != null) {
                    node.right.val = list.get(index) - siblingSum;
                    q.offer(node.right);
                }
            }
            index++;
        }
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        if(root == null) return root;

        // Step 1: Get the current row sum
        List<Integer> list = new ArrayList<>();
        levelSum(root, list);

        // Step 2: Assign values
        assign(root, list);

        return root;
    }
}