package c1_1000.c103_二叉树的锯齿形层序遍历;

import entity.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean isLeft = true;
    while (!queue.isEmpty()) {
      int size = queue.size();
      LinkedList<Integer> levelList = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        if (isLeft) {
          levelList.offerLast(cur.val);
        } else {
          levelList.offerFirst(cur.val);
        }
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
      ans.add(levelList);
      isLeft = !isLeft;
    }
    return ans;
  }

  public static void main(String[] args) {
    zigzagLevelOrder(null);
  }
}
