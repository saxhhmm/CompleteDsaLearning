class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                seenDigit = true;
                
            } else if (c == '+' || c == '-') {
                // A sign is only valid at the start or immediately after an 'e'/'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
                
            } else if (c == 'e' || c == 'E') {
                // An exponent is only valid if we haven't seen one yet, and we already have a digit
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                // Reset seenDigit because we MUST have a digit after the exponent
                seenDigit = false;
                
            } else if (c == '.') {
                // A decimal is only valid if we haven't seen one yet, and we aren't in the exponent part
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
                
            } else {
                // Any other character (letters, spaces, etc.) makes it invalid
                return false;
            }
        }
        
        // The entire string is valid only if it ends with a valid digit sequence
        return seenDigit;
    }
}