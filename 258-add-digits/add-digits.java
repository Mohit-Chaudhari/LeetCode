class Solution {
    public int addDigits(int num) {
        int value = num;

        while(value > 9) {

            int newValue = 0, rem;

            while(value != 0) {
                rem = value % 10;
                newValue += rem;
                value = value / 10;
            }

            value = newValue;
        }

        return value;
    }
}