class Solution {

    private void prepare(HashMap<String, Integer> words, String str) {
        for(String s: str.split(" ")) {
            if(words.containsKey(s)) words.put(s, words.get(s) + 1);
            else words.put(s, 1);
        }
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> words = new HashMap<>();
        int index = 0, counter = 0;

        prepare(words, s1);
        prepare(words, s2);

        for(String key: words.keySet()) {
            if(words.get(key) <= 1) counter++;
        }

        String[] uncommon = new String[counter];
        for(String key: words.keySet()) {
            if(words.get(key) <= 1) {
                uncommon[index] = key;
                index++;
            }
        }

        return uncommon;
    }
}