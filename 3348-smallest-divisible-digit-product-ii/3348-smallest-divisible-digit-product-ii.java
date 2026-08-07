import java.util.*;

class Solution {

    private static final int[][] FACTORS = {
        {0,0,0,0},
        {0,0,0,0},
        {1,0,0,0},
        {0,1,0,0},
        {2,0,0,0},
        {0,0,1,0},
        {1,1,0,0},
        {0,0,0,1},
        {3,0,0,0},
        {0,2,0,0}
    };

    public String smallestNumber(String num, long t) {

        int[] need = new int[4];
        int[] primes = {2, 3, 5, 7};

        for (int i = 0; i < 4; i++) {
            while (t % primes[i] == 0) {
                need[i]++;
                t /= primes[i];
            }
        }

        if (t != 1)
            return "-1";

        int[] full = getDigitCount(need);

        if (countDigits(full) > num.length())
            return construct(full);

        int[] prefix = new int[4];

        for (char ch : num.toCharArray())
            add(prefix, ch - '0');

        int firstZero = num.indexOf('0');

        if (firstZero == -1) {
            firstZero = num.length();

            if (covers(prefix, need))
                return num;
        }

        for (int i = num.length() - 1; i >= 0; i--) {

            int digit = num.charAt(i) - '0';

            remove(prefix, digit);

            int spaces = num.length() - 1 - i;

            if (i > firstZero)
                continue;

            for (int bigger = digit + 1; bigger <= 9; bigger++) {

                int[] missing = subtract(need, prefix);
                missing = subtract(missing, FACTORS[bigger]);

                int[] required = getDigitCount(missing);

                int requiredDigits = countDigits(required);

                if (requiredDigits <= spaces) {

                    StringBuilder ans = new StringBuilder();

                    ans.append(num, 0, i);
                    ans.append(bigger);

                    ans.append("1".repeat(
                            spaces - requiredDigits
                    ));

                    ans.append(construct(required));

                    return ans.toString();
                }
            }
        }

        int[] required = getDigitCount(need);

        int requiredDigits = countDigits(required);

        return "1".repeat(
                num.length() + 1 - requiredDigits
        ) + construct(required);
    }

    private int[] getDigitCount(int[] count) {

        int twos = count[0];
        int threes = count[1];

        int[] digits = new int[10];

        // 2^3 = 8
        digits[8] = twos / 3;
        int remaining2 = twos % 3;

        // 3^2 = 9
        digits[9] = threes / 2;
        int remaining3 = threes % 2;

        // 2^2 = 4
        digits[4] = remaining2 / 2;
        digits[2] = remaining2 % 2;

        // Combine 2 * 3 = 6
        if (digits[2] == 1 && remaining3 == 1) {
            digits[2] = 0;
            remaining3 = 0;
            digits[6] = 1;
        }

        // Important special case:
        // 4 * 3 = 12
        // but 2 * 6 = 12 and gives smaller number
        if (digits[4] == 1 && remaining3 == 1) {
            digits[4] = 0;
            remaining3 = 0;

            digits[2] = 1;
            digits[6] = 1;
        }

        digits[3] = remaining3;

        digits[5] = count[2];
        digits[7] = count[3];

        return digits;
    }

    private void add(int[] count, int digit) {
        for (int i = 0; i < 4; i++)
            count[i] += FACTORS[digit][i];
    }

    private void remove(int[] count, int digit) {
        for (int i = 0; i < 4; i++)
            count[i] -= FACTORS[digit][i];
    }

    private int[] subtract(int[] a, int[] b) {

        int[] result = new int[4];

        for (int i = 0; i < 4; i++)
            result[i] = Math.max(0, a[i] - b[i]);

        return result;
    }

    private boolean covers(int[] have, int[] need) {

        for (int i = 0; i < 4; i++) {
            if (have[i] < need[i])
                return false;
        }

        return true;
    }

    private int countDigits(int[] digits) {

        int total = 0;

        for (int d = 2; d <= 9; d++)
            total += digits[d];

        return total;
    }
    private String construct(int[] digits) {

        StringBuilder result = new StringBuilder();

        for (int d = 2; d <= 9; d++) {
            result.append(
                String.valueOf(d).repeat(digits[d])
            );
        }

        return result.toString();
    }
}