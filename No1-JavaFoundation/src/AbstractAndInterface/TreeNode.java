package AbstractAndInterface;

/**
 * @author Chen Manman
 * @since 2023/4/11 21:22
 */
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
