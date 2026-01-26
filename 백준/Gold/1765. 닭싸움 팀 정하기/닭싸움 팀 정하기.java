import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] parent;
	static List<Integer>[] enemy;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1];
		enemy = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			enemy[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (cmd.equals("F")) {
				union(a, b);
			} else if(cmd.equals("E")) {
				for (int e : enemy[a]) {
                    union(e, b);
                }
                for (int e : enemy[b]) {
                    union(e, a);
                }
                enemy[a].add(b);
                enemy[b].add(a);
			}
		}
		
		Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(find(i));
        }
        
        System.out.println(set.size());
	}
	
	public static int find(int idx) {
		if (parent[idx] == idx) return idx;
		return parent[idx] = find(parent[idx]);
	}
	
	public static void union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		
		if (a == b) return;
		
		if (ra > rb) {
			parent[rb] = ra;
		} else {
			parent[ra] = rb;
		}
	}
}
