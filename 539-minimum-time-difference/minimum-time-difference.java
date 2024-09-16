class Solution {

    private Integer calculateTime(String time) {
        String[] t = time.split(":");
        return (Integer.parseInt(t[0]) * 60) + Integer.parseInt(t[1]);
    }

    public int findMinDifference(List<String> timePoints) {
        
        int n = timePoints.size();
        int[] minutes = new int[n];
        int index = 0;

        for(String time: timePoints) {
            minutes[index] = calculateTime(time);
            index++;
        }

        Arrays.sort(minutes);

        Integer result = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            result = Math.min(result, minutes[i] - minutes[i - 1]);
        }

        return Math.min(result, (24 * 60 - minutes[n - 1]) + minutes[0]);
    }
}