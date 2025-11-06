import java.util.*;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        String s = sc.next();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c - 'A' + 1);
               
           	if (i != s.length() - 1) {
                sb.append(" ");
            }
        }
            
        System.out.print(sb.toString());
    }
}
