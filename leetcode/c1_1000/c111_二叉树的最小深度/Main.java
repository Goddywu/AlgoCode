package c1_1000.c111_二叉树的最小深度;

import entity.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  /**
   * bfs
   */

  private static class KV {
    public TreeNode node;
    public int depth;

    public KV(TreeNode node, int depth) {
      this.node = node;
      this.depth = depth;
    }
  }

  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    Queue<KV> queue = new LinkedList<>();
    queue.offer(new KV(root, 1));
    while (!queue.isEmpty()) {
      KV kv = queue.poll();
      if (kv.node.left == null && kv.node.right == null)
        return kv.depth;
      if (kv.node.left != null)
        queue.offer(new KV(kv.node.left, kv.depth + 1));
      if (kv.node.right != null)
        queue.offer(new KV(kv.node.right, kv.depth + 1));
    }
    return 0;
  }

  /**
   * dfs
   */
  public int minDepth2(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null)
      return 1;
    int minDepthNum = Integer.MAX_VALUE;
    if (root.left != null)
      minDepthNum = Math.min(minDepthNum, minDepth2(root.left) + 1);
    if (root.right != null)
      minDepthNum = Math.min(minDepthNum, minDepth2(root.right) + 1);
    return minDepthNum;
  }
}
