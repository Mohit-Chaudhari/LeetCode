class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;

        for(var detail: details) {
            int age = Integer.parseInt(detail.substring(11, 13));
            if (age > 60) ans++;
        }
        return ans;
    }
}