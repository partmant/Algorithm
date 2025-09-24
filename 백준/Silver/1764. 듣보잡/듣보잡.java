import java.util.*;
import java.io.*;

public class Main    {
    public static void main(String[] args) throws IOException   {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        int N = sc.nextInt(), M = sc.nextInt(); 

        for(int i=0;i<N;i++)
            set.add(sc.next());
        
        for(int i=0;i<M;i++)    {
            String name = sc.next();
            if(set.contains(name))    
                result.add(name);
        }
        
        Collections.sort(result);
        
        bw.write(result.size() + "\n");
        for (String name : result)
            bw.write(name + "\n");
        
        bw.flush();
    }
}