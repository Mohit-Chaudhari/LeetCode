class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        int[] cs = new int[n];
        boolean[] result = new boolean[m];

        // calculate a cumulative sum
        cs[0] = 0;
        for(int i = 1; i < n; i++) {
            if(nums[i] % 2 == nums[i - 1] % 2) {
                cs[i] = cs[i - 1] + 1;
            } else {
                cs[i] = cs[i - 1];
            }
        }

        for(int i = 0; i < m; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if(cs[end] - cs[start] == 0) result[i] = true;
            else result[i] = false;
        }

        return result;
    }
}