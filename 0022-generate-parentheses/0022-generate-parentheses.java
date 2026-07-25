import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder current, int open, int close, int n) {
        // If the current string has reached the maximum length of 2*n, add it to results
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }
        
        // Add an opening bracket if we haven't used all n of them
        if (open < n) {
            current.append('(');
            backtrack(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
        
        // Add a closing bracket if it won't exceed the number of opening brackets
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}