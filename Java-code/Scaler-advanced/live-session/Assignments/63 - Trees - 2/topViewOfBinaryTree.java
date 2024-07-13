import java.util.ArrayList;
import java.util.HashMap;
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

class Pair {
    TreeNode Node;
    int level;
    Pair (TreeNode A, int B) {
        Node = A;
        level = B;
    }
}
public class topViewOfBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {
        TreeNode tempA = A;
        Queue<Pair> que = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        Pair pr = new Pair(tempA, 0);
        que.add(pr);
        int min = 0, max = 0;
        
        while(!que.isEmpty()) {
            int ct = 1;
            int N = que.size();
            while(ct <= N) {
                Pair curPair = que.peek();
                TreeNode node = curPair.Node;
                int level = curPair.level;
                min = Integer.min(min, level);
                max = Integer.max(max, level);

                if(hm.containsKey(level)) {
                    ArrayList<Integer> ar = hm.get(level);
                    ar.add(node.val);
                    hm.put(level, ar);
                } else {
                    ArrayList<Integer> ar = new ArrayList<>();
                    ar.add(node.val);
                    hm.put(level, ar);
                }

                if(node.left != null) {
                    Pair newPair = new Pair(node.left, level - 1);
                    que.add(newPair);
                }
                if(node.right != null) {
                    Pair newPair = new Pair(node.right, level + 1);
                    que.add(newPair);
                }
                
                que.poll();
                ct += 1;
            }
        }
        ArrayList<Integer> topView = new ArrayList<>();
        for(int i = min; i <= max; i++) {
            topView.add(hm.get(i).get(0));
        }
        return topView;
    }
}
