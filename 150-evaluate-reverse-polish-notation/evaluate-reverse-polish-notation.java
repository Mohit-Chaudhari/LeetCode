class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str: tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                compute(str, a, b, stack);
            } else stack.push(Integer.parseInt(str));
        }
        return stack.pop();
    }

    private void compute(String operation, Integer a, Integer b, Stack<Integer> stack) {
        switch(operation) {
            case "+":
                stack.push(b + a);
                break;
            case "-":
                stack.push(b - a);
                break;
            case "*":
                stack.push(b * a);
                break;
            case "/":
                stack.push(b / a);
                break;
        }
    }
}