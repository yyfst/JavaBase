package program.datastructure.stack;

import java.util.Stack;

public class LeetCode_0304 {
    class MyQueue {
        private Stack<Integer> in = new Stack<>();
        private Stack<Integer> out = new Stack<>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            in.push(x);

        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            transfer(in, out);
            return out.pop();
        }

        private void transfer(Stack<Integer> in, Stack<Integer> out) {
            if (!out.isEmpty()) {
                return;
            }

            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        /**
         * Get the front element.
         */
        public int peek() {
            transfer(in, out);
            return out.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return in.isEmpty() && out.empty();
        }
    }

}
