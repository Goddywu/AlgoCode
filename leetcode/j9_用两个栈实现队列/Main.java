package j9_用两个栈实现队列;

import java.util.Stack;

public class Main {

    class CQueue {
        Stack<Integer> tails;
        Stack<Integer> heads;

        public CQueue() {
            tails = new Stack<>();
            heads = new Stack<>();
        }

        public void appendTail(int value) {
            tails.add(value);
        }

        public int deleteHead() {
            if (heads.isEmpty()) {
                while (!tails.isEmpty()) {
                    heads.add(tails.pop());
                }
            }
            return heads.isEmpty() ? -1 : heads.pop();
        }
    }
}
