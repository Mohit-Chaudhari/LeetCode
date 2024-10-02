class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int[] temp = arr.clone();

        Arrays.sort(temp);

        HashMap<Integer, Integer> hm = new HashMap<>();
        int counter = 1;

        for(int element: temp) {
            if(!hm.containsKey(element)) {
                hm.put(element, counter++);
            }
        }

        for(int i = 0; i < arr.length; i++) {
            arr[i] = hm.get(arr[i]);
        }

        return arr;
    }
}