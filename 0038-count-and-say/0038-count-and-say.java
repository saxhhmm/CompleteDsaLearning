class Solution {
    public String countAndSay(int n) {
        // Base case
        String s = "1";
        
        // Generate the sequence up to n
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            
            // Iterate through the previous string to count consecutive characters
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - 1)) {
                    count++;
                } else {
                    // Append the count and the character when a different character is found
                    sb.append(count).append(s.charAt(j - 1));
                    count = 1; // Reset count for the new character
                }
            }
            // Append the final group
            sb.append(count).append(s.charAt(s.length() - 1));
            
            // Update the string for the next iteration
            s = sb.toString();
        }
        
        return s;
    }
}