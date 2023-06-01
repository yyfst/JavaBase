package program.datastructure.stack;

import java.util.Stack;

public class LeetCode_Offer30 {
    class MinStack {
        private Stack<Integer> stack;

        private Stack<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (min.isEmpty()) {
                min.push(x);
                return;
            }

            int peek = min.peek();
            min.push(Math.min(peek, x));
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min.peek();
        }
    }
}
