import java.util.*;

class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // score of the current (outermost) level

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0); // start a new scope
            } else {
                int inner = stack.pop();        // score inside this pair
                int val = Math.max(2 * inner, 1); // "()" => 1, "(A)" => 2*A
                stack.push(stack.pop() + val);  // add to the parent scope
            }
        }
        return stack.pop();
    }
}