class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> s = new HashSet<>();

        for(char c: allowed.toCharArray()) {
            s.add(c);
        }

        int counter = 0;

        for(String word: words) {
            boolean flag = true;
            for(char c: word.toCharArray()) {
                if(!s.contains(c)) flag = false;
            }

            if(flag) counter++;
        }

        return counter;
    }
}