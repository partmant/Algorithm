import java.io.*;
import java.util.*;

public class Main {

    static class Cow {
        int s, e;
        
        Cow(int s, int e) {
        	this.s = s; this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] chickens = new int[C];
        for (int i = 0; i < C; i++) {
        	chickens[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(chickens);

        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            cows[i] = new Cow(s, e);
        }

        Arrays.sort(cows, (a, b) -> {
            if (a.s != b.s) return a.s - b.s;
            return a.e - b.e;
        });

        PriorityQueue<Integer> ends = new PriorityQueue<>();

        int idx = 0;
        int count = 0;

        for (int t : chickens) {
            while (idx < N && cows[idx].s <= t) {
                ends.add(cows[idx].e);
                idx++;
            }

            while (!ends.isEmpty() && ends.peek() < t) {
                ends.poll();
            }

            if (!ends.isEmpty()) {
                ends.poll();
                count++;
            }
        }

        System.out.println(count);
    }
}
