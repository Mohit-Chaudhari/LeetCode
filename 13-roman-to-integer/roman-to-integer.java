class Solution {

    private int value(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }

    public int romanToInt(String s) {
        // HashMap<Character, Integer> roman = new HashMap<>();
        int ans = 0;

        // roman.put('I', 1);
        // roman.put('V', 5);
        // roman.put('X', 10);
        // roman.put('L', 50);
        // roman.put('C', 100);
        // roman.put('D', 500);
        // roman.put('M', 1000);

        for(int i = 0; i < s.length(); i++) {
            if(i + 1 < s.length() && value(s.charAt(i)) < value(s.charAt(i + 1))) {
                ans += (value(s.charAt(i + 1)) - value(s.charAt(i)));
                i++;
            } else {
                ans += value(s.charAt(i));
            }
            // if(i + 1 < s.length() && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
            //     ans += (roman.get(s.charAt(i + 1)) - roman.get(s.charAt(i)));
            //     i++;
            // } else {
            //     ans += roman.get(s.charAt(i));
            // }
        }

        return ans;
    }
}