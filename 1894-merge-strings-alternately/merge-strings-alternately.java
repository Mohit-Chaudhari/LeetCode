class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = Math.min(word1.length(), word2.length());
        String str = "";

        for(int i = 0; i < n; i++) {
            str += String.valueOf(word1.charAt(i));
            str += String.valueOf(word2.charAt(i));
        }

        if(word1.length() > n) str+= word1.substring(n);
        if(word2.length() > n) str+= word2.substring(n);

        return str;
    }
}