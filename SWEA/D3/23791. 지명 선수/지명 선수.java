import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            
            boolean[] visited = new boolean[N + 1];
            char[] players = new char[N + 1];
            
            int[] teamA = new int[N];
            int[] teamB = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                teamA[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                teamB[i] = Integer.parseInt(st.nextToken());
            }
            
            int idxA = 0;
            int idxB = 0;
            
            for (int round = 1; round <= N; round++) {
                if (round % 2 == 1) {
                    while (visited[teamA[idxA]]) {
                        idxA++;
                    }
                    int pick = teamA[idxA++];
                    players[pick] = 'A';
                    visited[pick] = true;
                } else {
                    while (visited[teamB[idxB]]) {
                    	idxB++;
                    }
                    int pick = teamB[idxB++];
                    players[pick] = 'B';
                    visited[pick] = true;
                }
            }
            
            for (int i = 1; i <= N; i++) {
                sb.append(players[i]);
            }
            sb.append("\n");
        }
        
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}
