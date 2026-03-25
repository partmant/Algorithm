import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder(br.readLine());
        
        while(sb.length() > S.length()) {
        	int idx = sb.length() - 1;
        	if (sb.charAt(idx) == 'A') {
        		sb.delete(idx, idx + 1);
        	} else {
        		sb.delete(idx, idx + 1);
        		sb = sb.reverse();
        	}
        	
        	if (sb.toString().equals(S)) {
        		System.out.println(1);
        		return;
        	}
        }
        
        System.out.println(0);
    }
}
