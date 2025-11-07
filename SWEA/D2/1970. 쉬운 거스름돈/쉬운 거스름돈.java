import java.util.*;

public class Solution {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int[] money  = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
        	int n = sc.nextInt();
            int[] result = new int[8];
            
            for (int i = 0; i < money.length; i++) {
            	if (n >= money[i]) {
                	result[i] = n / money[i];
                    n %= money[i];
                }
            }
            
            sb.append("#").append(t).append("\n");
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i]);
                if (i < result.length - 1) { 
                    sb.append(" ");
            	}
            }
            if (t < T) {
                sb.append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
}