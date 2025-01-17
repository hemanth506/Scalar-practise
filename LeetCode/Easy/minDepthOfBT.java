import Easy.TreeNode;

public class minDepthOfBT {
  int minDepthVal = Integer.MAX_VALUE;

  public int depth(TreeNode root, int depth) {
    if (root == null) {
      return 0;
    }
    int left = depth(root.left, depth + 1);
    int right = depth(root.right, depth + 1);

    if (left == 0 && right == 0) {
      minDepthVal = Integer.min(depth, minDepthVal);
    }

    return Integer.min(left, right) + 1;
  }

  public int minDepth(TreeNode root) {
    depth(root, 0);
    return (minDepthVal == Integer.MAX_VALUE) ? 0 : minDepthVal + 1;
  }
}
