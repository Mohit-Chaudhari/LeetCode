class Solution {

    private HashMap<String, Integer> getHM(String word) {

        HashMap<String, Integer> hm = new HashMap<>();

        for(int i = 0; i < word.length(); i++) {

            String ch = String.valueOf(word.charAt(i));
            if(hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) + 1);
            } else {
                hm.put(ch, 1);
            }
        }

        return hm;
    }

    private List<Integer> getCounts(HashMap<String, Integer> mp) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(mp.entrySet());
        List<Integer> counts = new ArrayList<>();

        Collections.sort(entries, (first, second) -> second.getValue().compareTo(first.getValue()));

        for(Map.Entry<String, Integer> entry: entries) {
            counts.add(entry.getValue());
        }

        return counts;
    }

    public int minimumPushes(String word) {
        Integer mul = 1, ans = 0, cnt = 0;
        HashMap<String, Integer> map = getHM(word);
        List<Integer> counts = getCounts(map);

        for(Integer count: counts) {
            ans = ans + (count * mul);
            cnt++;
            if(cnt % 8 == 0) mul++;
        }

        return ans;
    }
}