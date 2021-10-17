package 典型题目.d_bfs.c863_二叉树中所有距离为k的结点;

import entity.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
  List<Integer> ans = new ArrayList<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    // 1. 构建每个节点的父节点
    buildMap(root);
    // 2. 找到相应的结点
    findAns(target, null, 0,  k);

    return ans;
  }

  private void buildMap(TreeNode node) {
    if (node.left != null) {
      childParentMap.put(node.left, node);
      buildMap(node.left);
    }
    if (node.right != null) {
      childParentMap.put(node.right, node);
      buildMap(node.right);
    }
  }

  private void findAns(TreeNode node, TreeNode from, int depth, int k) {
    if (node == null) return;

    if (depth == k) {
      ans.add(node.val);
      return;
    }
    if (node.left != from) {
      findAns(node.left, node, depth + 1, k);
    }
    if (node.right != from) {
      findAns(node.right, node, depth + 1, k);
    }
    if (childParentMap.get(node) != from) {
      findAns(childParentMap.get(node), node, depth + 1, k);
    }
  }
}
