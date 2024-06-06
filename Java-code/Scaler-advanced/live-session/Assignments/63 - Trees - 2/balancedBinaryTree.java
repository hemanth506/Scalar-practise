class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
public class balancedBinaryTree {
    public int helper (TreeNode A) {
        if(A == null) {
            return 0;
        }
        int lst = helper(A.left);
        int rst = helper(A.right);
        if(Math.abs(rst - lst) > 1) {
            resp = false;
        }

        return 1 + Integer.max(lst, rst);
    }
    boolean resp = true;
    public int isBalanced(TreeNode A) {
        helper(A);
        return resp ? 1: 0;
    }
}
