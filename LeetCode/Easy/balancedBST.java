import Easy.TreeNode;

public class balancedBST {
  boolean isBalanced = true;

  public int balancedTree(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = balancedTree(root.left);
    int right = balancedTree(root.right);
    if (Math.abs(left - right) > 1) {
      isBalanced = false;
    }

    return Integer.max(left, right) + 1;
  }

  public boolean isBalanced(TreeNode root) {
    balancedTree(root);
    return isBalanced;
  }

}
