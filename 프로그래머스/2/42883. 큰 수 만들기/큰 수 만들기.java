import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            
            // 이전값이 현재값보다 작고 k가 남아있다면
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            
            if (k == 0) {
                sb.append(number.substring(i));
                break;
            }
            
            sb.append(c);
        }
        
        if (k > 0) {
            sb.delete(sb.length() - k, sb.length());
        }
        
        return sb.toString();
    }
}