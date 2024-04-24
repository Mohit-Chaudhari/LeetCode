class Solution {
    public int search(int[] nums, int target) {
        
        int n = nums.length;
        int left = 0, right = n - 1;

        while(left <= right) {
            int pointer = (left + right) / 2;
            if(nums[pointer] == target) return pointer;
            else if(nums[pointer] < target) left = pointer + 1;
            else right = pointer - 1;
        }
        return -1;
    }
}