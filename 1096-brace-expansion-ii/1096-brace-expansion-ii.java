import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> set = evaluate(expression);
        List<String> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

    private Set<String> evaluate(String expr) {
        Set<String> resultSet = new HashSet<>();
        List<Set<String>> currentGroup = new ArrayList<>(); // Concatenation group
        
        int n = expr.length();
        int i = 0;
        
        while (i < n) {
            char c = expr.charAt(i);
            
            if (c == '{') {
                // Find matching closing brace
                int openBraces = 1;
                int start = i + 1;
                i++;
                while (i < n && openBraces > 0) {
                    if (expr.charAt(i) == '{') openBraces++;
                    else if (expr.charAt(i) == '}') openBraces--;
                    i++;
                }
                // Recursively evaluate inner expression
                Set<String> subRes = evaluate(expr.substring(start, i - 1));
                currentGroup.add(subRes);
            } else if (c == ',') {
                // Comma ends the current concatenated product group
                resultSet.addAll(combineGroup(currentGroup));
                currentGroup.clear();
                i++;
            } else {
                // Single character letter
                Set<String> letterSet = new HashSet<>();
                letterSet.add(String.valueOf(c));
                currentGroup.add(letterSet);
                i++;
            }
        }
        
        // Add the last concatenated group
        resultSet.addAll(combineGroup(currentGroup));
        return resultSet;
    }

    // Computes the Cartesian product of a list of string sets
    private Set<String> combineGroup(List<Set<String>> group) {
        if (group.isEmpty()) return Collections.emptySet();
        
        Set<String> current = group.get(0);
        for (int i = 1; i < group.size(); i++) {
            Set<String> next = group.get(i);
            Set<String> product = new HashSet<>();
            for (String s1 : current) {
                for (String s2 : next) {
                    product.add(s1 + s2);
                }
            }
            current = product;
        }
        return current;
    }
}