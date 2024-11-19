class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        Map<Integer, Integer> prevIdx = new HashMap<>();
        long curSum = 0;
        
        int l = 0;
        
        for (int r = 0; r < nums.length; r++) {
            curSum += nums[r];
            
            int i = prevIdx.getOrDefault(nums[r], -1);
            
            while (l <= i || r - l + 1 > k) {
                curSum -= nums[l];
                l++;
            }
            
            if (r - l + 1 == k) {
                res = Math.max(res, curSum);
            }
            
            prevIdx.put(nums[r], r);
        }
        
        return res;
    }
}