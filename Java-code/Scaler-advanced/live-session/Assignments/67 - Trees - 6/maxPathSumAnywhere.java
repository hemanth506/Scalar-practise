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
public class maxPathSumAnywhere {
    int maxV = Integer.MIN_VALUE;
    public int pathS(TreeNode A) {
        if(A == null) {
            return 0;
        }
        int l = pathS(A.left);
        int r = pathS(A.right);
        maxV = Integer.max(maxV, A.val + Integer.max(l, 0) + Integer.max(0, r));
        return Integer.max(Integer.max(l, 0), Integer.max(0, r)) + A.val;
    }
    public int maxPathSum(TreeNode A) {
        pathS(A);
        return maxV;
    }
}
