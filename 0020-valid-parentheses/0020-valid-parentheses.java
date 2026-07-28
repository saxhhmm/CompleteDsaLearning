import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // Push expected matching closing bracket or push opening brackets
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                // If stack is empty or top doesn't match current closing character
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        
        // Return true if all opening brackets were properly closed
        return stack.isEmpty();
    }
}