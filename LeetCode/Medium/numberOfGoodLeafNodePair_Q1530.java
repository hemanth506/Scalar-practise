import java.util.ArrayList;
import java.util.HashSet;
// import java.util.Iterator;

import Medium.TreeNode;

public class numberOfGoodLeafNodePair_Q1530 {
    ArrayList<TreeNode> allLeafNodes;
    ArrayList<HashSet<TreeNode>> storage;
    HashSet<TreeNode> curStk;

    numberOfGoodLeafNodePair_Q1530() {
        allLeafNodes = new ArrayList<>();
        storage = new ArrayList<>();
    }

    public int countPairs(TreeNode root, int distance) {
        getAllLeafNodes(root);

        getPathOfNodes(root);

        int totalPairs = getLeafNodePairs(root, distance);
        System.out.println(totalPairs);
        return totalPairs;
    }

    private int getLeafNodePairs(TreeNode root, int distance) {
        int totalpairs = 0;
        for(int i = 0; i < storage.size(); i++) {
            HashSet<TreeNode> topI = new HashSet<>();
            topI = storage.get(i);
            for(int j = 0; j < storage.size(); j++) {
                HashSet<TreeNode> tempJ = new HashSet<>();
                tempJ = storage.get(j);

                HashSet<TreeNode> tempI = new HashSet<>();
                tempI = topI;

                // Iterator itr = tempI.iterator();
                // while (itr.hasNext()) {
                //     if(tempJ.contains(itr.next())) {
                //         tempI.remove(itr.next());
                //         tempJ.remove(itr.next());
                //     }
                // }

                int curDistance = tempI.size() + tempJ.size();
                if(curDistance <= distance) {
                    totalpairs += 1;
                }
            }
        }
        return totalpairs;
    }


    private void getPathOfNodes(TreeNode root) {
        for(int i = 0; i < allLeafNodes.size(); i++) {
            curStk = new HashSet<>();
            getPath(allLeafNodes.get(i), root, curStk);
            storage.add(curStk);
        }
    }

    private boolean getPath(TreeNode node, TreeNode root, HashSet<TreeNode> curStk) {
        if(root == null) {
            return false;
        }

        if(root == node) {
            curStk.add(root);
            return true;
        }

        if(getPath(node, root.left, curStk) || getPath(node, root.right, curStk)) {
            curStk.add(root);
            return true;
        }

        return false;
    }

    private void getAllLeafNodes(TreeNode root) {
        if (root.left == null && root.right == null) {
            allLeafNodes.add(root);
            return;
        }
        if (root.left != null) {
            getAllLeafNodes(root.left);
        }

        if (root.right != null) {
            getAllLeafNodes(root.right);
        }
    }

}
