import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (isCorrect(s.substring(i) + s.substring(0, i))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
                if (c == ')' && top != '(') return false;
            }
        }
        
        return stack.isEmpty();
    }
}