import java.io.*;
import java.util.*;

class Solution {
    static Map<String, Integer> toNum = new HashMap<>();
    static Map<Integer, String> toStr = new HashMap<>();
    
    static {
        String[] word = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
        for (int i = 0; i < 10; i++) {
            toNum.put(word[i], i);
            toStr.put(i, word[i]);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String testNum = st.nextToken();
            int inputCount = Integer.parseInt(st.nextToken());
            int[] numCount = new int[10];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < inputCount; i++) {
                int num = toNum.get(st.nextToken());
                numCount[num]++;
            }
            
            sb.append(testNum).append("\n");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < numCount[i]; j++) {
                    sb.append(toStr.get(i)).append(" ");
                }
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
