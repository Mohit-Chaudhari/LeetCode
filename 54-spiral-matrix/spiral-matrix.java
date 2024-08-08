class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0, top = 0;
        int right = col - 1, bottom = row - 1;

        while(left <= right && top <= bottom) {

            // Left >> Right
            for(int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            // Top >> Bottom
            for(int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            // Right >> Left
            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;   
            }

            // Bottom >> Top
            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;
    }
}