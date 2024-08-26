/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    private void dfs(Node root, List<Integer> list) {
        for(Node child: root.children) {
            dfs(child, list);
        }
        list.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        if(root == null) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }
}