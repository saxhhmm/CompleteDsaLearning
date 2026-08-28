class Solution {
    public String reverseWords(String s) {
        // Step 1 & 2: Trim the string and split it by one or more spaces
        String[] words = s.trim().split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        
        // Step 3: Iterate backwards through the array of words
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            
            // Add a single space after every word EXCEPT the last one we append
            if (i > 0) {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}