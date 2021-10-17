package c1_1000.c94_二叉树的中序遍历;

import entity.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    inorderTraversal(ans, root);
    return ans;
  }

  private void inorderTraversal(List<Integer> ans, TreeNode node) {
    if (node == null) return;
    inorderTraversal(ans, node.left);
    ans.add(node.val);
    inorderTraversal(ans, node.right);
  }
}
