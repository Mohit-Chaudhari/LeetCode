class Solution {

    private Integer solve(Integer a, Integer b, char op) {
        if(op == '+') return a + b;
        else if(op == '-') return a - b;
        else return a * b;
    }

    List<Integer> solve(String s) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '+' || c == '-' || c == '*') {
                List<Integer> leftResults = solve(s.substring(0, i));
                List<Integer> rightResults = solve(s.substring(i+1));

                for(int x: leftResults) {
                    for(int y: rightResults) {
                        result.add(solve(x, y, c));
                    }
                }
            }
        }

        if(result.isEmpty()) result.add(Integer.parseInt(s));

        return result;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }
}