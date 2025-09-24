import java.io.*;
import java.util.*;

public class Main    {
    public static void main(String[] args) throws IOException    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, List<String>> map = new TreeMap<>();

        int N = Integer.parseInt(br.readLine());
        
        for(int i=0;i<N;i++)    {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.computeIfAbsent(Integer.parseInt(st.nextToken()), k -> new ArrayList<>()).add(st.nextToken());    
        }
        
        for(Map.Entry<Integer, List<String>> entry : map.entrySet())    
            for(String name:entry.getValue())    
                sb.append(entry.getKey()).append(" ").append(name).append("\n");

        sb.setLength(sb.length()-1);
        
        System.out.print(sb);
    }
}