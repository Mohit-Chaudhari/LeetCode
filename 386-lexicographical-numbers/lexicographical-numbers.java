class Solution {

    public void solve(List<Integer> list, int n, int startNum) {
        if(startNum > n) return;

        list.add(startNum);

        for(int append = 0; append <= 9; append++) {
            int newNumber = (startNum * 10) + append;

            if(newNumber > n) return;
            solve(list, n, newNumber);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();

        for(int startingNumber = 1; startingNumber <= 9; startingNumber++) {
            solve(list, n, startingNumber);
        }
        return list;
    }
}