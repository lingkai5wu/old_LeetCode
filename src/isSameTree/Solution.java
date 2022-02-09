package isSameTree;

import binaryTree.TreeNode;
import binaryTree.TreeOperation;

public class Solution {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根

	TreeNode p = TreeOperation.stringTo("[1,2,3]");
	TreeNode q = TreeOperation.stringTo("[1,2,3]");

	TreeOperation.printlnTree("p", p);
	TreeOperation.printlnTree("q", q);

	System.out.println(new Solution().isSameTree(p, q));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
	if (p == null && q == null) {
	    return true;
	}
	if (p == null || q == null || (p.val != q.val)) {
	    return false;
	}

	return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
