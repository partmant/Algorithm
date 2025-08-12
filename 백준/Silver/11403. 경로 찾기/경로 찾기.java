import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		boolean[][] distance = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1)
					distance[i][j] = true;
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (distance[i][k] == true && distance[k][j] == true)
						distance[i][j] = true;
				}
			}
		}

		for (boolean[] i : distance) {
			for (boolean j : i) {
				if (j == true)
					bw.write("1 ");
				else
					bw.write("0 ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
