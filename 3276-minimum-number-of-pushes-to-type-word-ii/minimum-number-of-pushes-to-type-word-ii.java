class Solution {

    private Integer[] getCounts(String word) {
        int[] frequencies = new int[26];
        for(char c: word.toCharArray()) {
            frequencies[c - 'a']++;
        }

        Integer[] counts = new Integer[26];
        for (int i = 0; i < 26; i++) {
            counts[i] = frequencies[i];
        }

        Arrays.sort(counts, Collections.reverseOrder());
        return counts;
    }

    public int minimumPushes(String word) {
        Integer mul = 1, ans = 0, cnt = 0;
        Integer[] counts = getCounts(word);

        for(Integer count: counts) {
            ans = ans + (count * mul);
            cnt++;
            if(cnt % 8 == 0) mul++;
        }

        return ans;
    }
}