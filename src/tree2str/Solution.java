package tree2str;

import binaryTree.BinaryTreeOperation;
import binaryTree.TreeNode;

public class Solution {

    public static void main(String[] args) {
        // TODO �Զ����ɵķ������

        TreeNode root = BinaryTreeOperation.stringTo("[1,2,3,null,4]");
        System.out.println(new Solution().tree2str(root));
    }

    StringBuilder sb = new StringBuilder();

    public String tree2str(TreeNode root) {
        // base case
        if (root == null) {
            return "";
        }
        traverse(root);
        return sb.toString();
    }

    void traverse(TreeNode root) {
        sb.append(root.val);
        // �������ǿ�
        if (root.left != null) {
            sb.append("(");
            traverse(root.left);
            sb.append(")");
            // ���������ˣ��������ǿ�
        } else if (root.right != null) {
            sb.append("()");
        }
        // �����������Ƿ�գ��������ǿ�
        if (root.right != null) {
            sb.append("(");
            traverse(root.right);
            sb.append(")");
        }
    }
}
