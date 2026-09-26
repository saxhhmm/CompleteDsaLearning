import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // Step 1: Map knowledge pairs into a HashMap for O(1) retrieval
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }
        
        StringBuilder result = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean insideBracket = false;
        
        // Step 2: Iterate through string s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                insideBracket = true;
                key.setLength(0); // Clear previous key
            } else if (c == ')') {
                insideBracket = false;
                String k = key.toString();
                // Replace key with mapped value, or "?" if key isn't found
                result.append(map.getOrDefault(k, "?"));
            } else {
                if (insideBracket) {
                    key.append(c);
                } else {
                    result.append(c);
                }
            }
        }
        
        return result.toString();
    }
}