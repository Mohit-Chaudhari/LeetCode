class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        
        HashSet<Integer> s = new HashSet<>();
        int n = 0;

        for(int num: arr1) {
            while(num > 0 && !s.contains(num)) {
                s.add(num);
                num /= 10;
            }
        }

        System.out.println(s);
        for(int num: arr2) {

            while(num > 0 && !s.contains(num)) {
                num /= 10;
            }

            if(num > 0) {
                n = Math.max(n, (int) (Math.log10(num) + 1));
            }
        }

        return n;
    }
}