class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int left = 0, top = 0, counter = 1;
        int right = n - 1, bottom = n - 1;

        while(left <= right && top <= bottom) {

            // left to right
            for(int i = left; i <= right; i++) {
                matrix[top][i] = counter++;
            }
            top++;

            // top to bottom
            for(int i = top; i <= bottom; i++) {
                matrix[i][right] = counter++;
            }
            right--;

            // right to left
            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                    matrix[bottom][i] = counter++;
                }
                bottom--;
            }

            // bottom to top
            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    matrix[i][left] = counter++;
                }
                left++;
            }
        }

        return matrix;
    }
}