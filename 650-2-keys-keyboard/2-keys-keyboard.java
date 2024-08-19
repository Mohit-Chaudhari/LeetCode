class Solution {
    public int minSteps(int n) {
        if (n == 1) return 0;
        if (n == 2) return 2;

        int remaining = n, clipBoard = 0, count = 1, steps = 0;

        while(count < n) {
            remaining = n - count;

            // Perform copy + paste operation
            if(remaining % count == 0) {
                clipBoard = count;
                count *= 2;
                steps += 2;
            } else {
                // Only paste operation
                count += clipBoard;
                steps++;
            }
        }

        return steps;
    }
}