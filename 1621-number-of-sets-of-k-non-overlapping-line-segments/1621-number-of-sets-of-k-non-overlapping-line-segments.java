class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        // We need to calculate C(N, R) where N = n + k - 1 and R = 2 * k
        long N = n + k - 1;
        long R = 2 * k;

        if (R > N) return 0;

        long numerator = 1;
        long denominator = 1;

        for (long i = 1; i <= R; i++) {
            numerator = (numerator * (N - i + 1)) % MOD;
            denominator = (denominator * i) % MOD;
        }

        // Calculate (numerator / denominator) % MOD using Fermat's Little Theorem
        return (int) ((numerator * modInverse(denominator, MOD)) % MOD);
    }

    private long modInverse(long base, int exp) {
        return power(base, exp - 2);
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}