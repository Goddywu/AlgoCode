package c104_二叉树的最大深度;

import entity.TreeNode;

public class Main {

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    public int maxDepth(TreeNode node, int depth) {
        if (node == null) return depth;
        int l = maxDepth(node.left, depth + 1);
        int r = maxDepth(node.right, depth + 1);
        return Math.max(l, r);
    }
}
