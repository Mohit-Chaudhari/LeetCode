class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        return minimumTimeToEatBananas(piles, h);
    }

    private static int minimumTimeToEatBananas(int[] piles, int h) {
        int start = 1, end = findMax(piles);

        while(start <= end) {
            int mid = (start + end) / 2;

            if(calculateMinHour(piles, mid) <= h) end = mid - 1;
            else start = mid + 1;
        }

        return start;
    }

    private static int findMax(int[] piles) {
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++) {
            maxi = Math.max(maxi, piles[i]);
        }
        return maxi;
    }

    private static int calculateMinHour(int[] piles, int hour) {
        int total = 0;

        for(int i = 0; i < piles.length; i++) {
            total += Math.ceil((double)(piles[i]) / (double)(hour));
        }

        return total;
    }
}