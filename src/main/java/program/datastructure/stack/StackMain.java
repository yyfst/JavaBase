package program.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 3, 5, 6};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peek()] > array[i]) {
                stack.pop();
            }
            if (!stack.isEmpty() && array[stack.peek()] < array[i]) {
                System.out.println("first data < array[" + i + "]=" + array[i] + " is: array[" + stack.peek() + "] = " + array[stack.peek()]);
            } else {
                System.out.println("no data < array[" + i + "]=" + array[i]);
            }
            stack.push(i);
        }
    }


}
