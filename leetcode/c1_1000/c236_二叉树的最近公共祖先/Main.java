package c1_1000.c236_二叉树的最近公共祖先;

import entity.TreeNode;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

  /**
   * 一、存储父节点和深度
   */

  static class ParentDepth {
    TreeNode parent;
    int depth;

    public ParentDepth(TreeNode parent, int depth) {
      this.parent = parent;
      this.depth = depth;
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    HashMap<TreeNode, ParentDepth> childParent = new HashMap<>();
    buildMap(root, childParent, 1);
    while (p != q) {
      if (p == root || q == root) return root;
      ParentDepth pPD = childParent.get(p);
      ParentDepth qPD = childParent.get(q);
      if (pPD.depth == qPD.depth) {
        p = pPD.parent;
        q = qPD.parent;
      } else if (pPD.depth > qPD.depth) {
        p = pPD.parent;
      } else {
        q = qPD.parent;
      }
    }
    return p;
  }

  private void buildMap(TreeNode node, HashMap<TreeNode, ParentDepth> childParent, int depth) {
    if (node == null) return;
    if (node.left != null) {
      childParent.put(node.left, new ParentDepth(node, depth + 1));
      buildMap(node.left, childParent, depth + 1);
    }
    if (node.right != null) {
      childParent.put(node.right, new ParentDepth(node, depth + 1));
      buildMap(node.right, childParent, depth + 1);
    }
  }

  /**
   * 二、存储父节点，记录访问与否
   */
  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    buildMap(root, map);
    HashSet<TreeNode> visit = new HashSet<>();
    while (p != null) {
      visit.add(p);
      p = map.get(p);
    }
    while (q != null) {
      if (visit.contains(q)) return q;
      q = map.get(q);
    }
    return null;
  }

  private void buildMap(TreeNode node, HashMap<TreeNode, TreeNode> map) {
    if (node == null) return;
    if (node.left != null) {
      map.put(node.left, node);
      buildMap(node.left, map);
    }
    if (node.right != null) {
      map.put(node.right, node);
      buildMap(node.right, map);
    }
  }

  /**
   * 三、dfs
   */
  public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor3(root.left, p, q);
    TreeNode right = lowestCommonAncestor3(root.left, p, q);
    if (left != null && right != null) return root;
    if (left != null) return left;
    if (right != null) return right;
    return null;
//    if (left == null && right == null) return null;
//    if (left == null) return right;
//    if (right == null) return left;
//    return root;
  }
}
