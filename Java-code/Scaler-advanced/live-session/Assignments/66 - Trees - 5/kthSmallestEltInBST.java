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

public class kthSmallestEltInBST {
    int smallestNumEx = 0;
    int ctEx = 0;
    public void checkSmallestWithExtra(TreeNode A, int B) {
        if (A == null) {
            return;
        }
        checkSmallestWithExtra(A.left, B);
        if (A != null) {
            if (ctEx < B) {
                smallestNumEx = A.val;
            }
            ctEx += 1;
        }
        checkSmallestWithExtra(A.right, B);
    }

    public int kthsmallestWithExtra(TreeNode A, int B) {
        checkSmallestWithExtra(A, B);
        return smallestNumEx;
    }

// -----------------------------------------------------

    public int checkSmallest(TreeNode A, int B) {
        TreeNode cur = A;
        int smallestNum = 0;
        int ct = 1;

        while (cur != null) {
            if (cur.left == null) {
                if (ct == B) {
                    smallestNum = cur.val;
                    break;
                }
                ct += 1;
                cur = cur.right;
            } else {
                TreeNode t = cur.left;
                while (t.right != null && t.right != cur) {
                    t = t.right;
                }
                if (t.right == null) {
                    t.right = cur;
                    cur = cur.left;
                } else {
                    if (ct == B) {
                        smallestNum = cur.val;
                        break;
                    }
                    ct += 1;
                    cur = cur.right;
                    t.right = null;
                }
            }
        }
        return smallestNum;
    }

    // With no extra Space
    public int kthsmallest(TreeNode A, int B) {
        return checkSmallest(A, B);
    }
}
