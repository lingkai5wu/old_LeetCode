package maxProduct;

import binaryTree.BinaryTreeOperation;
import binaryTree.TreeNode;

public class Solution {

    public static void main(String[] args) {
        // TODO �Զ����ɵķ������

        TreeNode root = BinaryTreeOperation.stringTo("[1,2,3,4,5,6]");
        System.out.println(new Solution().maxProduct(root));
    }

    long res = 0;
    int treeSum = 0;

    public int maxProduct(TreeNode root) {
        // ��������ͺ����õ��������Ľڵ�֮��
        treeSum = getSum(root);
        // �ٴε��ã����ú���λ�ü�������֮��
        getSum(root);
        return (int) (res % (1e9 + 7));
    }

    int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        int rootSum = leftSum + rightSum + root.val;
        res = Math.max(res, (long) rootSum * (treeSum - rootSum));
        return rootSum;
    }
}
