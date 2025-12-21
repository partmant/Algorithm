import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                list.add(new int[]{i, value});
            }
        }
        
        list.sort((a, b) -> {return a[1] - b[1];});
        
        int lIdx = 0;
        int min = Integer.MAX_VALUE;
        int[] count = new int[N];
        int included = 0;
        
        for (int rIdx = 0; rIdx < list.size(); rIdx++) {
            int[] right = list.get(rIdx);
            
            if (count[right[0]]++ == 0) {
                included++;
            }
            
            while (included == N) {
                int[] left = list.get(lIdx);
                
                min = Math.min(min, right[1] - left[1]);
                
                if (--count[left[0]] == 0) {
                    included--;
                }
                lIdx++;
            }
        }
        
        System.out.print(min);
    }
}
