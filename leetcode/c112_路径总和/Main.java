package c112_路径总和;

import entity.TreeNode;

public class Main {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum) return true;

        if (root.left != null) {
            if (hasPathSum(root.left, targetSum - root.val)) return true;
        }
        if (root.right != null) {
            if (hasPathSum(root.right, targetSum - root.val)) return true;
        }
        return false;
    }
}
