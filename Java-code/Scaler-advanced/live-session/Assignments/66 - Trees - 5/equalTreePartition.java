import java.util.HashSet;

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

public class equalTreePartition {
    HashSet<Long> hs;
    public int solve(TreeNode A) {
        hs = new HashSet<Long>();
        long totalSum = getTreeVal(A);
        if(totalSum%2 == 1) {
            return 0;
        }
        long halfSum = totalSum / 2;
        if(hs.contains(halfSum)) {
            return 1;
        }
        return 0;
    }

    public long getTreeVal(TreeNode A) {
        if(A == null) {
            return 0;
        }
        long val = getTreeVal(A.left) + getTreeVal(A.right) + A.val;
        hs.add(val);
        return val;
    }
}
