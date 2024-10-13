class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        
        // Priority Queue to store {element, listIdx, elementIdx}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        int maxEl = Integer.MIN_VALUE;
        
        // Initialize the priority queue with the first element of each list
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums.get(i).get(0), i, 0});
            maxEl = Math.max(maxEl, nums.get(i).get(0));
        }
        
        // Initialize result range with large numbers
        int[] resultRange = { -1000000, 1000000 };
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int minEl = curr[0];
            int listIdx = curr[1];
            int idx = curr[2];
            
            // Update the result range if the current range is smaller
            if (maxEl - minEl < resultRange[1] - resultRange[0]) {
                resultRange[0] = minEl;
                resultRange[1] = maxEl;
            }
            
            // Try to move to the next element in the list that contained the minimum element
            if (idx + 1 < nums.get(listIdx).size()) {
                int nextElement = nums.get(listIdx).get(idx + 1);
                pq.offer(new int[]{nextElement, listIdx, idx + 1});
                maxEl = Math.max(maxEl, nextElement);  // Update maxEl with the new element
            } else {
                break;  // If one list is exhausted, we can't continue forming valid ranges
            }
        }
        
        return resultRange;
    }
}