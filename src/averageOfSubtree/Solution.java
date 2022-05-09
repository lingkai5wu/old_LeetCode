package averageOfSubtree;

import binaryTree.BinaryTreeOperation;
import binaryTree.TreeNode;

public class Solution {

    public static void main(String[] args) {
        // TODO �Զ����ɵķ������

        TreeNode root = BinaryTreeOperation.stringTo("[4,8,5,0,1,null,6]");
        System.out.println(new Solution().averageOfSubtree(root));
    }

    int res = 0;

    public int averageOfSubtree(TreeNode root) {
        traverse(root);
        return res;
    }

    int[] traverse(TreeNode root) {
        // res �зֱ��ǣ�����Ԫ�ظ���������Ԫ�غ�
        int[] cur = new int[2];
        if (root == null) {
            return cur;
        }
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        cur[0] = left[0] + right[0] + 1;
        cur[1] = left[1] + right[1] + root.val;
        if (cur[1] / cur[0] == root.val) {
            res++;
        }
        return cur;
    }
}
