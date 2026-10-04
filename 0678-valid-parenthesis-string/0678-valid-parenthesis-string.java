class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--; // If '*' acts as ')'
                maxOpen++; // If '*' acts as '('
            }

            // If maximum possible open brackets drops below 0, invalid string
            if (maxOpen < 0) {
                return false;
            }

            // minOpen cannot be negative (we ignore extra closing brackets accounted for by '*')
            minOpen = Math.max(0, minOpen);
        }

        // Return true if it's possible to balance all parentheses
        return minOpen == 0;
    }
}