class Solution {
    public String mergeAlternately(String word1, String word2) {
        int index1 = 0, index2 = 0;
        StringBuilder result = new StringBuilder();

        while(index1 < word1.length() && index2 < word2.length()) {
            result.append(word1.charAt(index1++));
            result.append(word2.charAt(index2++));
        }

        if(index1 < word1.length()) result.append(word1.substring(index1));
        if(index1 < word2.length()) result.append(word2.substring(index2));

        return result.toString();
    }
}