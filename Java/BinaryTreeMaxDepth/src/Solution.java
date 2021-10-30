public class Solution {
    int max = 1;
    int counter = 1;
    public int maxDepth(TreeNode root) {
        if(root == null) 
            return 0;        
        if(root.left != null) {
            dfs(root.left);
            System.out.print("Left: " + counter + ", ");
            counter--;
        }
        if(root.right != null) {
            dfs(root.right);
            System.out.print("Right: " + counter + ", ");
            counter--;
        }
        return max;
    }
    void dfs(TreeNode n) {
        counter++;
        if(max < counter) 
            max = counter;
        if(n.left != null) {
            dfs(n.left);
            System.out.print("Left: " + counter + ", ");
            counter--;
        }
        if(n.right != null) {
            dfs(n.right);
            System.out.print("Right: " + counter + ", ");
            counter--;
        }
    }
}
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
