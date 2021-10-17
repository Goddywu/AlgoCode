package c1_1000.c129_求根到叶子节点数字之和;

import entity.TreeNode;

public class Main {

  public int sumNumbers(TreeNode root) {
    return sumNumbers(root, 0);
  }

  public int sumNumbers(TreeNode node, int currentNum) {
    if (node == null) return 0;
    currentNum = currentNum * 10 + node.val;

    if (node.left == null && node.right == null)
      return currentNum;
    else
      return sumNumbers(node.left, currentNum) + sumNumbers(node.right, currentNum);
  }
}
