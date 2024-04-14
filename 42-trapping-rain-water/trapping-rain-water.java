class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int rMax = Integer.MIN_VALUE;
        int lMax = Integer.MIN_VALUE;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            lMax = Math.max(lMax, height[i]);
            left[i] = lMax;

            rMax = Math.max(rMax, height[n - i - 1]);
            right[n - i - 1] = rMax;
        }

        for(int i = 0; i < n; i++) {
            ans = ans + (Math.min(left[i], right[i]) - height[i]);
        }

        return ans;
    }
}