import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
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

public class diagonalTraversal {
    public ArrayList<Integer> solve(TreeNode A) {
        TreeNode tempA = A;
        ArrayList<Integer> arr = new ArrayList<>();
        if (A == null) {
            return arr;
        }
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        Deque<TreeNode> que = new LinkedList<>();
        int level = 0;
        que.add(tempA);
        ArrayList<Integer> temp = new ArrayList<>();

        while (!que.isEmpty() || tempA != null) {
            while (tempA != null) {
                if(level >= 0) {
                    if(hm.containsKey(level)) {
                        temp = hm.get(level);
                        temp.add(tempA.val);
                    } else {
                        temp = new ArrayList<>();
                        temp.add(tempA.val);
                    }
                    hm.put(level, temp);
                }
                que.add(tempA);
                tempA = tempA.left;
                level += 1;
            }
            tempA = que.peekLast().right;
            que.pollLast();
            level -= 1;
        }
        System.out.println(hm);

        for(int i = 0; i < hm.size(); i++) {
            for(int j = 0; j < hm.get(i).size(); j++) {
                arr.add(hm.get(i).get(j));
            }
        }
        return arr;
    }
}
