class Solution {
    private static class Node {
        int mx, lmx, rmx;
        char lc, rc;
    }

    private Node[] tree;
    private char[] chars;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        chars = s.toCharArray();
        int n = chars.length;
        tree = new Node[n << 2];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node();
        }
        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            update(1, 0, n - 1, idx, ch);
            ans[i] = tree[1].mx;
        }
        return ans;
    }

    private void build(int u, int l, int r) {
        if (l == r) {
            tree[u].mx = 1;
            tree[u].lmx = 1;
            tree[u].rmx = 1;
            tree[u].lc = chars[l];
            tree[u].rc = chars[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
        pushup(u, l, r);
    }

    private void update(int u, int l, int r, int idx, char ch) {
        if (l == r) {
            chars[idx] = ch;
            tree[u].lc = ch;
            tree[u].rc = ch;
            return;
        }
        int mid = (l + r) >> 1;
        if (idx <= mid) {
            update(u << 1, l, mid, idx, ch);
        } else {
            update(u << 1 | 1, mid + 1, r, idx, ch);
        }
        pushup(u, l, r);
    }

    private void pushup(int u, int l, int r) {
        int leftIdx = u << 1;
        int rightIdx = u << 1 | 1;
        
        Node left = tree[leftIdx];
        Node right = tree[rightIdx];
        
        tree[u].lc = left.lc;
        tree[u].rc = right.rc;
        
        tree[u].mx = Math.max(left.mx, right.mx);
        tree[u].lmx = left.lmx;
        tree[u].rmx = right.rmx;

        int mid = (l + r) >> 1;
        int leftLen = mid - l + 1;
        int rightLen = r - mid;

        if (left.rc == right.lc) {
            tree[u].mx = Math.max(tree[u].mx, left.rmx + right.lmx);
            if (left.lmx == leftLen) {
                tree[u].lmx = left.lmx + right.lmx;
            }
            if (right.rmx == rightLen) {
                tree[u].rmx = right.rmx + left.rmx;
            }
        }
    }
}