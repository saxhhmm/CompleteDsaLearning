class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;   // unmatched '('
        int added = 0;  // '(' we must insert for unmatched ')'

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (open > 0) {
                open--;      // matches an earlier '('
            } else {
                added++;     // unmatched ')', needs a '(' inserted
            }
        }
        return open + added; // leftover '(' each need a ')'
    }
}