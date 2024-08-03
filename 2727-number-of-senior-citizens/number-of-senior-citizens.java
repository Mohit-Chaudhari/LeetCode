import java.util.regex.Matcher; 
import java.util.regex.Pattern; 

class Solution {

    private int getAge(String detail) {
        Pattern p = Pattern.compile(".{2}(?=(.{2})$)");
        Matcher m = p.matcher(detail);
        if(m.find()) return Integer.parseInt(m.group());
        return 0;
    }
    public int countSeniors(String[] details) {
        int cnt = 0;
        for(String detail: details) {
            if(getAge(detail) > 60) cnt++;
        }
        return cnt;
    }
}