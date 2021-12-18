public class Solution {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return recursion(nums, 0, nums.length);
	}

	TreeNode recursion(int[] arr, int l, int r) {
		if (l == r)
			return null;
		int index = findMaxIndex(arr, l, r);
		TreeNode root = new TreeNode(arr[index]);
		root.left = recursion(arr, l, index);
		root.right = recursion(arr, index + 1, r);
		return root;
	}

	int findMaxIndex(int[] a, int l, int r) {
		int largeIndex = l;
		for (int i = l; i < r; i++)
			if (a[largeIndex] < a[i])
				largeIndex = i;
		return largeIndex;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}