import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			if (N == 0 && K == 0)
				break;

			st = new StringTokenizer(br.readLine());

			int[] nodes = new int[N + 1];
			for (int i = 0; i < N; i++) {
				nodes[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] parent = new int[N + 1];
			parent[0] = -1;
            parent[1] = 0;
            
            int pIdx = 0;
            for (int i = 2; i <= N; i++) {
                if (nodes[i] != nodes[i - 1] + 1) {
                    pIdx++;
                }
                parent[i] = pIdx;
            }

			int kIdx = 0;
			for (int i = 0; i < N; i++) {
				if (nodes[i] == K) {
					kIdx = i;
					break;
				}
			}

			int cnt = 0;
			for (int i = 1; i < N; i++) {
				if (parent[i] != parent[kIdx] && parent[parent[i]] == parent[parent[kIdx]]) {
					cnt++;
				}
			}

			System.out.println(cnt);
		}
	}
}
