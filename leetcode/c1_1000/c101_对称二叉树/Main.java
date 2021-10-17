package c1_1000.c101_对称二叉树;


import entity.TreeNode;

public class Main {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        else if (t1 == null) return false;
        else if (t2 == null) return false;

        if (t1.val != t2.val) return false;

        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }
}
