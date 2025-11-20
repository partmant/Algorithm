import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] table = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                String[] tmp = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    table[i][j] = Integer.parseInt(tmp[j]);
                }
            }
            
            int count = 0;
            
            // 열 단위 스캔
            for (int col = 0; col < N; col++) {
                boolean hasN = false;  // 1을 만났는가?
                
                for (int row = 0; row < N; row++) {
                    if (table[row][col] == 1) {
                        hasN = true; 
                    } 
                    else if (table[row][col] == 2) {
                        if (hasN) {
                            count++;
                            hasN = false;
                        }
                    }
                }
            }
            
            sb.append("#").append(tc).append(" ").append(count).append("\n");
        }
        
        System.out.print(sb);
    }
}
