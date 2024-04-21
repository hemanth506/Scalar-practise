import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Medium.TreeNode;

public class LevelOrderTraversalII_Q107 {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> finalList = new ArrayList<>();
    Queue<TreeNode> que = new LinkedList<>();
    if(root != null) {
      que.add(root);
    }

    while (!que.isEmpty()) {
      int N = que.size();
      ArrayList<Integer> arr = new ArrayList<>();
      for(int i = 0; i < N; i++) {
        TreeNode nd = que.poll();
        arr.add(nd.val);
        if(nd.left != null) {
          que.add(nd.left);
        }

        if(nd.right != null) {
          que.add(nd.right);
        }
      } 

      finalList.add(arr);
    }

    int i = 0;
    int j = finalList.size()-1;
    while(i <= j) {
      List<Integer> temp = finalList.get(i);
      finalList.set(i, finalList.get(j));
      finalList.set(j, temp);
      i++;
      j--;
    }
    return finalList;
  }
}
