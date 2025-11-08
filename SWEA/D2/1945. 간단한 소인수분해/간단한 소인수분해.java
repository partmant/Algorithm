import java.util.*;

public class Solution {
    static int[] primes = {2, 3, 5, 7, 11};
    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
        	int n = sc.nextInt();
            int[] result = new int[primes.length];
            
            for (int i = 0; i < primes.length ; i++) {
                while (n % primes[i] == 0) {
                	n /= primes[i];
                    result[i]++;
                }
            }
            
            sb.append("#").append(t).append(" ");
            for (int i = 0; i < result.length; i++) {
            	sb.append(result[i]);
                if (i != result.length - 1) {
                	sb.append(" ");
                } else {
                	sb.append("\n");
                }
            }
        }
        
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}