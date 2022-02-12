package bstToGst;

import binaryTree.TreeNode;
import binaryTree.TreeOperation;

public class Solution {

    public static void main(String[] args) {
	// TODO �Զ����ɵķ������

	TreeNode root = TreeOperation.stringTo("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]");
	TreeNode res = new Solution().bstToGst(root);
	TreeOperation.printlnTree(res);
	TreeOperation.printlnWithoutEndingNull(res);
    }

    public TreeNode bstToGst(TreeNode root) {
	traverse(root);
	return root;
    }

    int sum = 0;

    void traverse(TreeNode root) {
	if (root == null) {
	    return;
	}

	traverse(root.right);
	sum += root.val;
	root.val = sum;
	traverse(root.left);
    }
}
