package inorderTraversal;

import java.util.ArrayList;
import java.util.List;

import binaryTree.TreeNode;
import binaryTree.TreeOperation;
import list.ArrayListOperation;

public class Solution {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根

	TreeNode root = TreeOperation.stringTo("[1,null,2,3]");
	TreeOperation.printlnTree(root);
	ArrayListOperation.printlnIntList(new Solution().inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
	List<Integer> res = new ArrayList<>();
	inorder(root, res);
	return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
	if (root == null) {
	    return;
	}
	inorder(root.left, res);
	res.add(root.val);
	inorder(root.right, res);
    }
}
