package c543_二叉树的直径;

import entity.TreeNode;

public class Main {

  int max = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    dfs(root);
    return max;
  }

  private int dfs(TreeNode node) {
    if (node == null) return 0;
    int left = dfs(node.left);
    int right = dfs(node.right);
    max = Math.max(left + right, max);
    return Math.max(left, right) + 1;
  }
}
