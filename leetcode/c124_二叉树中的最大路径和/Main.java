package c124_二叉树中的最大路径和;

import entity.TreeNode;

// https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
public class Main {

  /**
   * 最大路径和：根据当前节点的角色，路径和可分为两种情况：
   *     一：以当前节点为根节点
   *     1.只有当前节点
   *     2.当前节点+左子树
   *     3.当前节点+右子书
   *     4.当前节点+左右子树
   *     这四种情况的最大值即为以当前节点为根的最大路径和
   *     此最大值要和已经保存的最大值比较，得到整个树的最大路径值
   *
   *     二：当前节点作为父节点的一个子节点
   *     和父节点连接的话则需取【单端的最大值】
   *     1.只有当前节点
   *     2.当前节点+左子树
   *     3.当前节点+右子书
   *     这三种情况的最大值
   */
  int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    return maxGain(root);
  }

  private int maxGain(TreeNode node) {
    if (node == null) return 0;

    int left = Math.max(0, maxGain(node.left));
    int right = Math.max(0, maxGain(node.right));
    int newPath = node.val + left + right;
    max = Math.max(max, newPath);
    return node.val + Math.max(left, right);
  }
}
