import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // Step 1: Build the adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] inv : invocations) {
            graph.get(inv[0]).add(inv[1]);
        }
        
        // Step 2: Find all suspicious methods starting from k using DFS
        boolean[] isSuspicious = new boolean[n];
        dfs(k, graph, isSuspicious);
        
        // Step 3: Check if any non-suspicious method invokes a suspicious method
        boolean isolated = true;
        for (int[] inv : invocations) {
            int u = inv[0];
            int v = inv[1];
            // If an outside method (not suspicious) calls an inside method (suspicious)
            if (!isSuspicious[u] && isSuspicious[v]) {
                isolated = false;
                break;
            }
        }
        
        // Step 4: Build and return the result list
        List<Integer> result = new ArrayList<>();
        if (isolated) {
            // If isolated, exclude all suspicious methods
            for (int i = 0; i < n; i++) {
                if (!isSuspicious[i]) {
                    result.add(i);
                }
            }
        } else {
            // If not isolated, none can be removed, return all methods
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    private void dfs(int node, List<List<Integer>> graph, boolean[] isSuspicious) {
        isSuspicious[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!isSuspicious[neighbor]) {
                dfs(neighbor, graph, isSuspicious);
            }
        }
    }
}