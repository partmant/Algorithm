import java.util.*;

class Solution {
	static final String[] colors = {"red", "orange", "yellow", "green", "blue", "purple"};
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
    	
        Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < colors.length; i++) {
        	map.put(colors[i], i);
        }
        
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
        	int idx1 = map.get(sc.next());
            int idx2 = map.get(sc.next());
            
            if (idx1 == idx2) {
                sb.append("E");
            } else if ((idx1 + 1) % 6 == idx2 || (idx1 + 5) % 6 == idx2) {
            	sb.append("A");
            } else if ((idx1 + 3) % 6 == idx2) {
            	sb.append("C");
            } else {
            	sb.append("X");
            }
           	sb.append("\n"); 
        }
    
        sb.setLength(sb.length() - 1);
        
        System.out.print(sb);
    }
}
