package c30_包含min函数的栈;

import java.util.Stack;

public class Main {

    class MinStack {
        Stack<Integer> nums;
        Stack<Integer> mins;

        /** initialize your data structure here. */
        public MinStack() {
            nums = new Stack<>();
            mins = new Stack<>();
        }

        public void push(int x) {
            nums.add(x);
            if (mins.isEmpty()) {
                mins.add(x);
            } else {
                mins.add(Math.min(x, min()));
            }
        }

        public void pop() {
            nums.pop();
            mins.pop();
        }

        public int top() {
            return nums.peek();
        }

        public int min() {
            return mins.isEmpty() ? -1 : mins.peek();
        }
    }
}
