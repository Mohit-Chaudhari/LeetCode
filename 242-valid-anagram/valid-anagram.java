class Solution {
    public boolean isAnagram(String s, String t) {
        String[] sc = s.split("");
        String[] tc = t.split("");

        HashMap<String, Integer> shm = new HashMap<>();
        HashMap<String, Integer> thm = new HashMap<>();

        for(String c: sc) {
            if(shm.containsKey(c)) {
                shm.put(c, shm.get(c) + 1);
            } else {
                shm.put(c, 1);
            }
        }

        for(String c: tc) {
            if(thm.containsKey(c)) {
                thm.put(c, thm.get(c) + 1);
            } else {
                thm.put(c, 1);
            }
        }

        return shm.equals(thm);
    }
}