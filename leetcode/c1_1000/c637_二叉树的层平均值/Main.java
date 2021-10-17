package c1_1000.c637_二叉树的层平均值;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-17
 */
public class Main {

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (true) {
            if (queue.isEmpty()) {
                break;
            }
            int pollSize = queue.size();
            double count = 0d;
            for (int i = 0; i < pollSize; i++) {
                TreeNode poll = queue.poll();
                count += (double) poll.val;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }

            result.add(count / pollSize);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode tree1 = TreeNode.ofArray(new Integer[]{3, 9, 20, null, null, 15, 7});
        TreeNode tree2 = TreeNode.ofArray(new Integer[]{3, 9, 20, 15, 7});

        // [3.00000,14.50000,11.00000]
        System.out.println(averageOfLevels(tree1));
        // [3.00000,14.50000,11.00000]
        System.out.println(averageOfLevels(tree2));
    }

}
