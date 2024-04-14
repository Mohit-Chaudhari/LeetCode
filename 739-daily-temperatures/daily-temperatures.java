class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] op = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            // Pop the elements till greater element encountered or stack is empty
            while(!stack.empty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            // Push the output when the greater element found
            if (!stack.empty()) {
                op[i] = stack.peek() - i;
            }
            // Push the index of the current element
            stack.push(i);
        }
        return op;
    }
}