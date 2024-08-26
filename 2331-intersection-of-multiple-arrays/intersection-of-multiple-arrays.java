class Solution {

    private HashMap<Integer, Integer> getMap(int[][] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int[] num: nums) {
            for(int n: num) {
                if(map.containsKey(n)) {
                    map.put(n, map.get(n) + 1);
                } else map.put(n, 1);
            }
        }

        return map;
    }

    public List<Integer> intersection(int[][] nums) {
        HashMap<Integer, Integer> hm = getMap(nums);
        List<Integer> list = new ArrayList<>();
 
        for(Integer key: hm.keySet()) {
            if(hm.get(key) == nums.length) {
                list.add(key);
            }
        }

        Collections.sort(list);
        return list;
    }
}