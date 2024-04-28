class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int start = 0, end = m * n - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            int col = mid % m;
            int row = mid / m;

            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) start = mid + 1;
            else end = mid - 1;
        }

        return false;
    }
}