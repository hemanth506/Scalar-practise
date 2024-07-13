import Medium.TreeNode;

public class pathSum {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (targetSum == 0) {
      return true;
    }
    int val = targetSum - root.val;
    return hasPathSum(root.left, val) || hasPathSum(root.right, val);
  }
}
