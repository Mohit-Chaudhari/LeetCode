class Solution {

    private HashMap<Integer, Integer> makeHashMap(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int o: arr) {
            if(hm.containsKey(o)) {
                hm.put(Integer.valueOf(o), hm.get(Integer.valueOf(o)) + Integer.valueOf(1));
            } else {
                hm.put(Integer.valueOf(o), Integer.valueOf(1));
            }
        }

        return hm;
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> thm = makeHashMap(target);
        HashMap<Integer, Integer> ahm = makeHashMap(arr);
        return thm.equals(ahm);
    }
}