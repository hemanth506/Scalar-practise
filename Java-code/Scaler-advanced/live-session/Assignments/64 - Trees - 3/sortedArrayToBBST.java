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
public class sortedArrayToBBST {

    public TreeNode sortedArrayToBST(final int[] A) {
        return formBBST(A, 0, A.length - 1);
    }

    public TreeNode formBBST(int[] A, int str, int end) {
        if(str > end) {
            return null;
        }
        int mid = (end - str)/2;
        TreeNode node = new TreeNode(mid);
        node.left = formBBST(A, str, mid-1);
        node.right = formBBST(A, mid+1, end);

        return node;

    }

}
