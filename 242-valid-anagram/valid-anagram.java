class Solution {

    private HashMap<String, Integer> getMap(String[] str) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String s: str) {
            if(map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
        }

        return map;
    }

    public boolean isAnagram(String s, String t) {
        String[] sstr = s.split("");
        String[] tstr = t.split("");

        HashMap<String, Integer> smap = getMap(sstr);
        HashMap<String, Integer> tmap = getMap(tstr);

        return smap.equals(tmap);        
    }
}