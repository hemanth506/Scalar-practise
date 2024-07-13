import java.util.ArrayList;

import Medium.TreeNode;

public class flattenBinaryTree {
  ArrayList<Integer> treeArr = new ArrayList<>();

  public void getArrayValue(TreeNode root) {
    if (root == null)
      return;
    treeArr.add(root.val);
    getArrayValue(root.left);
    getArrayValue(root.right);
  }

  public void flatten(TreeNode root) {
    if (root == null)
      return;
    getArrayValue(root);
    System.out.println(treeArr);

    int N = treeArr.size();

    if (N > 1) {
      root.left = null;
      root.right = new TreeNode(treeArr.get(1), null, null);
      TreeNode head = root.right;
      for (int i = 2; i < N; i++) {
        System.out.println(head.val);
        head.right = new TreeNode(treeArr.get(i), null, null);
        head = head.right;
      }
    }
  }
}
