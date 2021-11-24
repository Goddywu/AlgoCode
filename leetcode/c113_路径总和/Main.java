package c113_路径总和;

import entity.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Main {

  /**
   * dfs
   */
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(root, targetSum, new ArrayList<>(), ans);
    return ans;
  }

  private void dfs(TreeNode node, int targetSum, List<Integer> tmp, List<List<Integer>> ans) {
    if (node == null) return;
    tmp.add(node.val);
    targetSum -= node.val;
    if (node.left == null && node.right == null && targetSum == 0) {
      ans.add(new ArrayList<>(tmp));
    }
    dfs(node.left, targetSum, tmp, ans);
    dfs(node.right, targetSum, tmp, ans);
    tmp.remove(tmp.size() - 1);
  }
}
