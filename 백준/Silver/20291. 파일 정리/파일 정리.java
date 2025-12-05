import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Map<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            String ext = name.substring(name.lastIndexOf('.') + 1);
            freq.put(ext, freq.getOrDefault(ext, 0) + 1);
        }
        
        List<String> names = new ArrayList<>(freq.keySet());
        Collections.sort(names);
        
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name).append(" ").append(freq.get(name)).append("\n");
        }
        
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        
        System.out.print(sb);
    }
}
