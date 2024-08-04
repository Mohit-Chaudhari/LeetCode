class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] sums = new int[n * (n + 1) / 2];
        int ans = 0, idx = 0;
        final int mod = (int) 1e9 + 7;

        // CREATE SUM ARRAY
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                sums[idx++] = sum;
            }
        }

        // SORT SUM ARRAY
        Arrays.sort(sums);

        // CALCULATE THE SUM BETWEEN GIVEN INDEXES
        for(int i = left - 1; i < right; i++) {
            ans = (ans + sums[i]) % mod;
        }

        return ans;
    }
}