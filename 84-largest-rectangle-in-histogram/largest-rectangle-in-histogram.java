class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int leftMin[] = new int[n];
        int rightMin[] = new int[n];
        int maxi = Integer.MIN_VALUE;

        // First pass to calculate left min
        for(int i = 0; i < n; i++) {
            while(!stack.empty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if(stack.empty()) leftMin[i] = 0;
            else leftMin[i] = stack.peek() + 1;
            stack.push(i);
        }

        // Second pass to calculate right min
        stack.clear();
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.empty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if(stack.empty()) rightMin[i] = n - 1;
            else rightMin[i] = stack.peek() - 1;
            stack.push(i);
            maxi = Math.max(maxi, (rightMin[i] - leftMin[i] + 1) * heights[i]);
        }

        return maxi;
    }
}