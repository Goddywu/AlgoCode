package c1_1000.c232_用栈实现队列;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-03-07
 */
public class Main {
    static class MyQueue {

        private final Stack<Integer> old2newStack; //               [1,2,3    ]  <-
        private final Stack<Integer> new2oldStack; // -> [    1,2,3]

        public MyQueue() {
            old2newStack = new Stack<>();
            new2oldStack = new Stack<>();
        }

        public void push(int x) { // 将元素 x 推到队列的末尾
            old2newStack.push(x);
        }

        public int pop() { // 从队列的开头移除并返回元素
            if (new2oldStack.isEmpty()) {
                while (!old2newStack.isEmpty()) {
                    new2oldStack.push(old2newStack.pop());
                }
            }
            return new2oldStack.pop();
        }

        public int peek() { // 返回队列开头的元素
            if (new2oldStack.isEmpty()) {
                while (!old2newStack.isEmpty()) {
                    new2oldStack.push(old2newStack.pop());
                }
            }
            return new2oldStack.peek();
        }

        public boolean empty() { // 如果队列为空，返回 true ；否则，返回 false
            return old2newStack.isEmpty() && new2oldStack.empty();
        }

        public void print() {
            while (!new2oldStack.isEmpty()) {
                old2newStack.push(new2oldStack.pop());
            }
            Iterator<Integer> iterator = old2newStack.iterator();
            List<String> list = new ArrayList<>();
            while (iterator.hasNext()) {
                list.add(iterator.next() + "");
            }
            System.out.println("[" + String.join(",", list) + "]");

        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.print();

        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.print();

        myQueue.peek(); // return 1
        myQueue.print();

        myQueue.pop(); // return 1, queue is [2]
        myQueue.print();

        myQueue.empty(); // return false
        myQueue.print();

    }
}
