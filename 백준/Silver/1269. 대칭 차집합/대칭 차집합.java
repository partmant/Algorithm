import java.util.*;
import java.io.*;

public class Main{    
    public static void main(String[] args) throws IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)    
            set.add(Integer.parseInt(st.nextToken()));
    
        int equals = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++)    
            if(set.contains(Integer.parseInt(st.nextToken())))
                equals++;
        
        System.out.println(M+N-equals*2);    
    }
}