class Solution {
    public List<Integer> intersection(int[][] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        int[] freq = new int[1001];

        for(int r = 0; r < nums.length; r++) {
            for(int c = 0; c < nums[r].length; c++) {
                freq[nums[r][c]]++;
            }
        }

        int n = nums.length;
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] == n) list.add(i);
        }

        return list;
    }
}