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

// work todo
class Pair {
    int maxV;
    int minV;
    boolean isBST;
    int size;
    Pair (int min, int max, int size, boolean bst) {
        this.maxV = max;
        this.minV = min;
        this.size = size;
        this.isBST = bst;
    }
}

public class largestBST {


    public Pair helper(TreeNode A) {
        if (A == null) {
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        boolean valid = true;
        Pair left = helper(A.left);
        Pair right = helper(A.right);

        if(left.isBST == true && right.isBST == true) {
            if(A.val <= left.maxV || A.val >= right.minV) {
                valid = false;
            }

        } else {
            valid = false;
        }

        int min = Integer.min(A.val, Integer.min(left.minV, right.minV));
        int max = Integer.min(A.val, Integer.min(left.maxV, right.maxV));

        if(valid) {
            return new Pair(min, max, left.size+right.size+1, valid);
        }

        return new Pair(min, max, Integer.max(right.size, left.size), valid);
    }
    public int solve(TreeNode A) {
        Pair val = helper(A);
        return val.size;
    }
}
