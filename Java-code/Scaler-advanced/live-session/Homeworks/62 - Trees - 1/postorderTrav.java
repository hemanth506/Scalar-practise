import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

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

// Data Right Left == Left Right Data
public class postorderTrav {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        TreeNode tempA = A;
        Deque<TreeNode> deq = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        while(!deq.isEmpty() || tempA != null) {
            while(tempA != null) {
                deq.add(tempA);
                arr.add(tempA.val);
                tempA = tempA.right;
            }
            tempA = deq.peekLast();
            deq.pollLast();
            tempA = tempA.left;
        }
        Collections.reverse(arr);
        return arr;
    }
}
