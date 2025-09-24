import java.util.*;
import java.io.*;

public class Main    {
    public static void main(String[] args) throws IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, String> map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for(int i=0;i<N;i++)    {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        
        for(int i=0;i<M;i++)    {
            String address = br.readLine();
            
            if(map.containsKey(address))
                bw.write(map.get(address)+"\n");
        }
        
        bw.flush();
    }
}