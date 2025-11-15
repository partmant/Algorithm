import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;     
    static boolean[] visited; 
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0);
        System.out.print(min);
    }
    
    static void dfs(int index, int count) {
        if (count == N / 2) {
            calc();
            return;
        }
        
        if (index >= N) return;
        
        visited[index] = true;
        dfs(index + 1, count + 1);
        
        visited[index] = false;
        dfs(index + 1, count);
       
    }
    
    static void calc() {
        int start = 0;
        int link = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start += S[i][j] + S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += S[i][j] + S[j][i];
                }
            } 
        }
        
        min = Math.min(min, Math.abs(start - link));
    }
}