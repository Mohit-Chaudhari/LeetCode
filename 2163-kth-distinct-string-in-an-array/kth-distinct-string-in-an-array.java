class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> mp = new HashMap<>();
        int count = 0;

        // CREATE A HASHMAP
        for(String s: arr) {
            if (mp.containsKey(s)) {
                mp.put(s, mp.get(s) + 1);
            } else {
                mp.put(s, 1);
            }
        }

        // ITERATE THROUGH ARRAY AND CHECK THE DISTINCT STRING
        for(String s: arr) {
            if(mp.get(s) == 1) count++;
            
            if(count == k) return s;
        }

        return "";
    }
}