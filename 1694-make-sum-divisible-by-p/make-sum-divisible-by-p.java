class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;

        // calculate the sum of all elements and % p
        for(int num: nums) {
            sum = (sum + num) % p;
        }

        int target = sum % p;

        // If sum is already dividible by P, no need to remove any subarray
        if(target == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, - 1); // Initialize with 0 remainder at index -1

        int curr = 0;
        int result = n;

        // Traverse through array
        for(int j = 0; j < n; j++) {
            curr = (curr + nums[j]) % p;
            
            // Calculate the remainder needed to achieve the target
            int remain = (curr - target + p) % p;

            // If the required reamainder exists in the map, update the result
            if(map.containsKey(remain)) {
                result = Math.min(result, j - map.get(remain));
            }

            // Store the current reaminder with it's index
            map.put(curr, j);
        }

        return result == n ? -1 : result;
    }
}