class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) {
            return 0;
        }

        int totalPoisonedTime = 0;

        for (int i = 0; i < timeSeries.length - 1; i++) {
            // Add the minimum of the full duration or the gap to the next attack
            totalPoisonedTime += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }

        // The last attack always lasts the full duration
        totalPoisonedTime += duration;

        return totalPoisonedTime;
    }
}