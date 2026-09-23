class Solution {
    static class Node {
        int totalProductMod;
        int[] prefixCounts;

        Node(int k) {
            this.totalProductMod = 1;
            this.prefixCounts = new int[k];
        }
    }

    private int k;
    private Node[] tree;
    private int n;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        this.n = nums.length;
        this.tree = new Node[4 * n];

        build(nums, 1, 0, n - 1);

        int[] result = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int idx = queries[q][0];
            int val = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            // Step 1: Update nums[idx] = val
            update(1, 0, n - 1, idx, val);

            // Step 2: Query range [start, n - 1]
            Node queryResult = query(1, 0, n - 1, start, n - 1);

            // Step 3: Get the count for remainder x
            result[q] = queryResult.prefixCounts[x];
        }

        return result;
    }

    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        Node parent = new Node(k);
        parent.totalProductMod = (int) ((1L * left.totalProductMod * right.totalProductMod) % k);

        // Include prefixes from the left child
        for (int r = 0; r < k; r++) {
            parent.prefixCounts[r] = left.prefixCounts[r];
        }

        // Include prefixes extending into the right child
        for (int r = 0; r < k; r++) {
            if (right.prefixCounts[r] > 0) {
                int combinedRem = (int) ((1L * left.totalProductMod * r) % k);
                parent.prefixCounts[combinedRem] += right.prefixCounts[r];
            }
        }

        return parent;
    }

    private void build(int[] nums, int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(k);
            int mod = nums[start] % k;
            tree[node].totalProductMod = mod;
            tree[node].prefixCounts[mod] = 1;
            return;
        }

        int mid = start + (end - start) / 2;
        build(nums, 2 * node, start, mid);
        build(nums, 2 * node + 1, mid + 1, end);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = new Node(k);
            int mod = val % k;
            tree[node].totalProductMod = mod;
            tree[node].prefixCounts[mod] = 1;
            return;
        }

        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private Node query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return null;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;
        Node leftNode = query(2 * node, start, mid, l, r);
        Node rightNode = query(2 * node + 1, mid + 1, end, l, r);

        return merge(leftNode, rightNode);
    }
}