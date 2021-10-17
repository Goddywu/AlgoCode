package c1_1000.c225_用队列实现栈;

import java.util.*;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-03-11
 */
public class Main {

    public static class MyStack {

        private final Queue<Integer> queue = new LinkedList<>(); //   <-  [1, 2, 3]   <-

        public MyStack() {

        }

        public void push(int x) { // 将元素 x 压入栈顶
            queue.offer(x);
        }

        public int pop() { // 移除并返回栈顶元素
            int size = queue.size();
            while (size > 1) {
                queue.add(queue.poll());
                size--;
            }
            return queue.poll();
        }

        public int top() { // 返回栈顶元素
            int size = queue.size();
            while (size > 1) {
                queue.add(queue.poll());
                size--;
            }
            Integer last = queue.poll();
            queue.add(last);
            return last;
        }

        public boolean empty() { // 如果栈是空的，返回 true ；否则，返回 false
            return queue.isEmpty();
        }

        public void print() {
            Iterator<Integer> iterator = queue.iterator();
            List<String> list = new ArrayList<>();
            while (iterator.hasNext()) {
                list.add(iterator.next() + "");
            }
            System.out.println("[" + String.join(",", list) + "]");
        }
    }

    public static class MyStack2 {
        private final Queue<Integer> queue = new LinkedList<>(); //    <-  [3, 2, 1]   <-


        public MyStack2() {

        }

        public void push(int x) {
            int size = queue.size();
            queue.add(x);
            while (size-- > 0) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }

    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.print();

        myStack.push(2);
        myStack.print();

        myStack.top(); // 返回 2
        myStack.print();

        myStack.pop(); // 返回 2
        myStack.print();

        myStack.empty(); // 返回 False
    }
}
