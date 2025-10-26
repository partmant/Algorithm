import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
        	int N = sc.nextInt();
            int result = 0;
            
            if (N % 2 == 1) {
            	result = N;
            }
            result -= (N / 2);
            
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        
        System.out.print(sb.toString());
    }
}