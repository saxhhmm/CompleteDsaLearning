class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] answer = new int[n];
        int depth = 0;

        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);

            if (c == '(') {
                // Assign based on current depth parity, then increment depth
                answer[i] = depth % 2;
                depth++;
            } else {
                // Decrement depth first, then assign to match the paired '('
                depth--;
                answer[i] = depth % 2;
            }
        }

        return answer;
    }
}