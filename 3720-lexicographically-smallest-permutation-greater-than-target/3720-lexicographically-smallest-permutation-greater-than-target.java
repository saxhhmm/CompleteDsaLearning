class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char ch : s.toCharArray()) count[ch - 'a']++;

        // Find max prefix length M that target[0..M-1] can be matched from s's letters
        int[] tmp = count.clone();
        int M = 0;
        for (int i = 0; i < n; i++) {
            int idx = target.charAt(i) - 'a';
            if (tmp[idx] > 0) {
                tmp[idx]--;
                M++;
            } else break;
        }

        int startK = Math.min(M, n - 1);

        int[] cnt = count.clone();
        for (int i = 0; i < startK; i++) {
            cnt[target.charAt(i) - 'a']--;
        }

        for (int k = startK; k >= 0; k--) {
            int tIdx = target.charAt(k) - 'a';
            int foundIdx = -1;
            for (int c = tIdx + 1; c < 26; c++) {
                if (cnt[c] > 0) { foundIdx = c; break; }
            }

            if (foundIdx != -1) {
                cnt[foundIdx]--;
                StringBuilder sb = new StringBuilder();
                sb.append(target, 0, k);
                sb.append((char) ('a' + foundIdx));
                for (int c = 0; c < 26; c++) {
                    for (int j = 0; j < cnt[c]; j++) sb.append((char) ('a' + c));
                }
                return sb.toString();
            }

            if (k > 0) {
                cnt[target.charAt(k - 1) - 'a']++;
            }
        }

        return "";
    }
}
