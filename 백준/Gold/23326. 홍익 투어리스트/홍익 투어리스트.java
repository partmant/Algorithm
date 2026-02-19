import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		TreeSet<Integer> sights = new TreeSet<>();
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n == 1) {
				sights.add(i);
			}
		}
		
		int cur = 1;
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			
			if (cmd == 1) {
				int x = Integer.parseInt(st.nextToken());
				if (sights.contains(x)) {
					sights.remove(x);
				} else sights.add(x);
			} else if (cmd == 2) {
				cur = (cur + Integer.parseInt(st.nextToken()) - 1) % N + 1;
			} else if (cmd == 3) {
				if (sights.isEmpty()) {
                    sb.append(-1).append('\n');
                    continue;
                }
				
				Integer next = sights.ceiling(cur);
				if (next != null) {
                    sb.append(next - cur).append('\n');
                } else {
                    next = sights.first();
                    sb.append(N - cur + next).append('\n');
                }
			}
		}
		
		System.out.print(sb);
	}
}
