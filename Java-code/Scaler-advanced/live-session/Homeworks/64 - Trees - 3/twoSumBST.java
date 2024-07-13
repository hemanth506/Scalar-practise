import java.util.ArrayList;
import java.util.Stack;

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

public class twoSumBST {
    ArrayList<Integer> arr = new ArrayList<>();

    public void insertAllNodeInArr(TreeNode A) {
        if (A == null) {
            return;
        }

        insertAllNodeInArr(A.left);
        arr.add(A.val);
        insertAllNodeInArr(A.right);
    }

    public int findNodes(int B) {
        int N = arr.size();
        int i = 0, j = N - 1;
        while (i < j) {
            int val = arr.get(i) + arr.get(j);
            if (val == B) {
                return 1;
            }
            if (val > B) {
                j -= 1;
            } else {
                i += 1;
            }
        }
        return 0;
    }

    public int t2SumWithNSpace(TreeNode A, int B) {
        insertAllNodeInArr(A);
        System.out.println(arr);
        int res = findNodes(B);
        System.out.println(res);
        return res;
    }

    // =================================================

    public int t2Sum(TreeNode A, int B) {
        int res = findNodesWithConstantSpace(A, B);
        System.out.println(res);
        return res;
    }

    public int findNodesWithConstantSpace(TreeNode A, int B) {
        if(A == null) {
            return 0;
        }
        Stack<TreeNode> leftStk = new Stack<TreeNode>();
        Stack<TreeNode> rightStk = new Stack<TreeNode>();

        TreeNode tempLeftA = A;
        while(tempLeftA != null) {
            leftStk.add(tempLeftA);
            tempLeftA = tempLeftA.left;
        }

        TreeNode tempRightA = A;
        while(tempRightA != null) {
            rightStk.add(tempRightA);
            tempRightA = tempRightA.right;
        }

        while(!rightStk.isEmpty() && !leftStk.isEmpty() && rightStk.peek().val > leftStk.peek().val) {
            int val = rightStk.peek().val + leftStk.peek().val;
            // System.out.println(rightStk.peek().val + " " + leftStk.peek().val);

            if (val == B) {
                return 1;
            }

            if (val < B) {
                TreeNode top = leftStk.pop();
                if (top.right != null) {
                    top = top.right;
                    while(top != null) {
                        leftStk.add(top);
                        top = top.left;
                    }
                }
            } else {
                TreeNode top = rightStk.pop();
                if (top.left != null) {
                    top = top.left;
                    while(top != null) {
                        rightStk.add(top);
                        top = top.right;
                    }
                }
            }  
        }

        // System.out.println(tempLeftA + " " + tempRightA + " " + leftStk + " " + rightStk);
        return 0;
    }
}
