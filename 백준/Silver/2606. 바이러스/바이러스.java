import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;
	static int[] rank;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		parent = new int[N + 1];
		rank = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		int K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			union(sc.nextInt(), sc.nextInt());
		}
		
		int count = 0;
		for (int i = 2; i <= N; i++) {
			if (find(1) == find(i)) {
				count++;
			}
		}
		
		System.out.print(count);
	}
    
    static int find(int x) {
    	if (parent[x] == x) {
    		return x;
    	}
    	return parent[x] = find(parent[x]);
    }
    
    static void union(int x, int y) {
    	x = find(x);
    	y = find(y);
    	
    	if (x != y) {
    		if (rank[x] > rank[y]) {
    			parent[y] = x;
    		} else if (rank[x] < rank[y]) {
    			parent[x] = y;
    		} else {
    			parent[x] = y;
    			rank[y]++;
    		}
    	}
    }
}
