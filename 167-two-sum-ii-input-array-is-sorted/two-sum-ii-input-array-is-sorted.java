class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            int leftNum = numbers[left];
            int rightNum = numbers[right];

            if (leftNum + rightNum < target) left++;
            else if (leftNum + rightNum > target) right--;
            else if (leftNum + rightNum == target) break;
        }

        return new int[] {left + 1, right + 1};
    }
}