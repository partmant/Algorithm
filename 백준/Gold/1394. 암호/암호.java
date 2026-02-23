import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		String line = br.readLine();
		
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 1; i <= line.length(); i++) {
			map.put(line.charAt(i - 1), i);
		}
		
		String pwd = br.readLine();
		int K = line.length();
		long cnt = 0;
		
		for (int i = 0; i < pwd.length(); i++) {
			int value = map.get(pwd.charAt(i));
			cnt = (cnt * K + value) % 900528;
		}
		
		System.out.println(cnt);
	}
}
