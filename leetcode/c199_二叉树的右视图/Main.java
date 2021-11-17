package c199_二叉树的右视图;

import entity.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

  /**
   * bfs
   */
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) return ans;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        TreeNode node = queue.poll();
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
        if (size == 0) ans.add(node.val);
      }
    }
    return ans;
  }

  /**
   * dfs
   */
  public List<Integer> rightSideView2(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    dfs(root, 0, ans);
    return ans;
  }

  private void dfs(TreeNode node, int depth, List<Integer> ans) {
    if (node == null) return;

    // 先访问 当前节点，再递归地访问 右子树 和 左子树
    if (depth == ans.size()) { // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中
      ans.add(node.val);
    }
    depth++;
    dfs(node.right, depth, ans);
    dfs(node.left, depth, ans);
  }
}
