
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode (int x) {
        val = x;
        left = right = null;
    }
}

// Used recursion code from Discussion section
public class binaryTreeToCircularDoublyLinkedList {
    TreeNode prev = null;
    TreeNode solve(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        prev = dummy;
        inOrderTraversal(dummy);
        return dummy.right;
    }

    public void inOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }

        inOrderTraversal(root.left);
        prev.right = root;
        root.left = prev;
        prev = prev.right;
        inOrderTraversal(root.right);
    }
}
