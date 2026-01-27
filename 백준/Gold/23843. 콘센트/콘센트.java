import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		List<Integer> list = new ArrayList<>();;
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		list.sort(Collections.reverseOrder());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int num = list.get(i);
			
			if (pq.size() < M) {
				pq.add(num);
			} else {
				pq.add(pq.poll() + num);
			}
		}
		
		int max = 0;
		while (!pq.isEmpty()) {
			max = Math.max(pq.poll(), max);
		}
		
		System.out.println(max);
	}
}
