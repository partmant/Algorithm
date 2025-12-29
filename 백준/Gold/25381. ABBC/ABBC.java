import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        
        Deque<Integer> idxB = new ArrayDeque<>();
        Deque<Integer> idxA = new ArrayDeque<>();
        
        boolean[] used = new boolean[line.length()];
        int answer = 0;
        
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            
            if (c == 'C') {
                if (!idxB.isEmpty()) {
                    used[idxB.pollFirst()] = true;
                    answer++;
                }
            } else if (c == 'B') {
                idxB.add(i);
            }
        }
        
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            
            if (c == 'A') {
                idxA.add(i);
            } else if (c == 'B') {
                if (used[i]) continue;
                
                if (!idxA.isEmpty()) {
                    idxA.pollFirst();
                    answer++;
                }
            }
        }
        
        System.out.print(answer);
    }
}
