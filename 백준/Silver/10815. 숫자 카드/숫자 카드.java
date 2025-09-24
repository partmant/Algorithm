import java.io.*;
import java.util.*;

public class Main    {
    public static void main(String[] args) throws IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<N;i++)    
            map.put(Integer.parseInt(st.nextToken()), 1);
        
        int M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++)    {
            int n = Integer.parseInt(st.nextToken());
            
            if(map.containsKey(n))
                bw.write("1 ");
            else
                bw.write("0 ");
        }
        bw.flush();
    }    
}