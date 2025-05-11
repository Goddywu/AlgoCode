package 二叉树.order4_前中后序_递归;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-20
 */
public class Main {

    private static class NodeMark {
        public TreeNode node;
        public boolean visitChild;

        public NodeMark(TreeNode node, boolean visitChild) {
            this.node = node;
            this.visitChild = visitChild;
        }
    }

    /**
      * 标记是否访问左右
      */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<NodeMark> stack = new Stack<>();
        stack.add(new NodeMark(root, false));

        while (!stack.isEmpty()) {
            NodeMark nodeMark = stack.peek();
            if (nodeMark.visitChild) {
                result.add(nodeMark.node.val);
                stack.pop();
            } else {
                nodeMark.visitChild = true;
                if (nodeMark.node.right != null) {
                    stack.add(new NodeMark(nodeMark.node.right, false));
                }
                if (nodeMark.node.left != null) {
                    stack.add(new NodeMark(nodeMark.node.left, false));
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }

}
