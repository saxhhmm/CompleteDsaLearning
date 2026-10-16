import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final int MOD = 1_000_000_007;

    class Node {
        long countTotal = 0;
        long sqTotal = 0;
        long lazy = 0;
        Node left, right;
    }

    private Node root = new Node();

    private void push(int l, int r, Node node) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();

        if (node.lazy != 0) {
            long len = r - l + 1;
            long newSqTotal = (node.sqTotal + 2 * node.lazy * node.countTotal + len * node.lazy % MOD * node.lazy) % MOD;
            long newCountTotal = (node.countTotal + len * node.lazy) % MOD;

            node.sqTotal = newSqTotal;
            node.countTotal = newCountTotal;

            if (l != r) {
                node.left.lazy = (node.left.lazy + node.lazy) % MOD;
                node.right.lazy = (node.right.lazy + node.lazy) % MOD;
            }
            node.lazy = 0;
        }
    }

    private void update(int l, int r, Node node, int ql, int qr) {
        push(l, r, node);
        if (ql > r || qr < l) return;
        if (ql <= l && r <= qr) {
            node.lazy = (node.lazy + 1) % MOD;
            push(l, r, node);
            return;
        }
        int mid = l + (r - l) / 2;
        update(l, mid, node.left, ql, qr);
        update(mid + 1, r, node.right, ql, qr);

        node.countTotal = (node.left.countTotal + node.right.countTotal) % MOD;
        node.sqTotal = (node.left.sqTotal + node.right.sqTotal) % MOD;
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> lastSeen = new HashMap<>();
        long totalSum = 0;

        for (int r = 0; r < n; r++) {
            int num = nums[r];
            int l = lastSeen.getOrDefault(num, -1) + 1;
            lastSeen.put(num, r);

            update(0, n - 1, root, l, r);
            totalSum = (totalSum + root.sqTotal) % MOD;
        }

        return (int) totalSum;
    }
}