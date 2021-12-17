public class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        return insertNode(root, val);
    }
    TreeNode insertNode(TreeNode root, int val) {
        TreeNode ret = new TreeNode(val);
        if(root == null)
            return ret;
        if(root.val < val) {
            ret.left = root;
            return ret;
        }
        root.right = insertNode(root.right, val);
        return root;
    }
}
//Definition for a binary tree node.
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}
