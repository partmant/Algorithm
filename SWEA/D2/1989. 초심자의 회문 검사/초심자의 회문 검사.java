import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int N = sc.nextInt();
        
        for (int t = 1; t <= N; t++) {
        	String s = sc.next();
            char[] c = s.toCharArray();
            int result = 1;
            
            for (int i = 0; i < c.length / 2; i++) {
            	if (c[i] != c[c.length - 1 - i]) {
                    result = 0;
                    break;
                }
            }
            
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        
        System.out.print(sb.toString());
    }
}