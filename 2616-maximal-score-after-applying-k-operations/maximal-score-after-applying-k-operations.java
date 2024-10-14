class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        long score = 0;

        for(int num: nums) {
            q.add(num);
        }

        while(k-- > 0) {
            int extract = q.poll();
            score += extract;
            q.offer((extract + 2) / 3);
        }

        return score;
    }
}