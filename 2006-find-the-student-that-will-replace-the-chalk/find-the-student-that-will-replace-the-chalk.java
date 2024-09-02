class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum =  0;

        for(int c: chalk) {
            sum += c;
        }

        int remainder = (int) (k % sum);
        
        for(int i = 0; i < chalk.length; i++) {
            if(chalk[i] > remainder) {
                return i;
            }

            remainder -= chalk[i];
        }

        return -1;
    }
}