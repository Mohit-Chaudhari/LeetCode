class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0, m = word1.length(), n = word2.length();
        StringBuilder result = new StringBuilder();

        while(i < m || j < n) {
            if(i < m) {
                result.append(word1.charAt(i));
                i++;
            }

            if(j < n) {
                result.append(word2.charAt(j));
                j++;
            }
        }

        return result.toString();
    }
}