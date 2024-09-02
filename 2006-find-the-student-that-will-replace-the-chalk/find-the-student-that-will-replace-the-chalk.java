class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        Long sum = Arrays.stream(chalk).mapToLong(n -> Long.valueOf(n)).sum();
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