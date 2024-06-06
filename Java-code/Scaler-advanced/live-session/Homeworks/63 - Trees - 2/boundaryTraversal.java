import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

public class boundaryTraversal {
    public ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> que = new LinkedList<>();
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();
        ArrayList<Integer> bottonArr = new ArrayList<>();

        que.add(A);

        while(!que.isEmpty()) {
            int N = que.size();
            int i = 0;
            int k = 0;
            while(i < N) {
                TreeNode curNode = que.poll();
                if(curNode.left == null && curNode.right == null) {
                    bottonArr.add(k, curNode.val); 
                    // Maintians the level order  set 1 : { 1 2 }
                    // Maintians the level order  set 2 : {1 2 3} added to { 1 2 3 1 2 }
                    // Maintians the level order  set 2 : {1 2 3 4} added to { 1 2 3 4 1 2 3 1 2 }

                    k++;
                } else {
                    if(i == 0) {
                        leftArr.add(curNode.val);
                    }

                    if(i == (N-1) && N > 1) {
                        rightArr.add(0, curNode.val); // Maintains the order
                    }

                }



                if(curNode.left != null) {
                    que.add(curNode.left);
                }

                if(curNode.right != null) {
                    que.add(curNode.right);
                }
                i++;
            }
            // arr.add(inner);
        }

        ArrayList<Integer> arr = leftArr;
        arr.addAll(bottonArr);
        arr.addAll(rightArr);

        System.out.println(arr);
        return null;
    }
}
