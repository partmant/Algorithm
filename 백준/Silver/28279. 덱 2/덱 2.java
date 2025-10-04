import java.util.*;
import java.io.*;

public class Main    {
    public static void main(String[] args) throws IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0;i<N;i++)    {
            String[] s = br.readLine().split(" ");
            int command = Integer.parseInt(s[0]);
            
            switch(command)    {
                case 1: 
                    dq.addFirst(Integer.parseInt(s[1]));
                    break;
                case 2: 
                    dq.add(Integer.parseInt(s[1]));
                    break;
                case 3: 
                    sb.append(dq.isEmpty()?-1:dq.poll()).append("\n");
                    break;
                case 4:
                    sb.append(dq.isEmpty()?-1:dq.pollLast()).append("\n");
                    break;
                case 5:
                    sb.append(dq.size()).append("\n");
                    break;
                case 6:
                    sb.append(dq.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 7:
                    sb.append(dq.isEmpty()?-1:dq.peek()).append("\n");
                    break;
                case 8:
                    sb.append(dq.isEmpty()?-1:dq.peekLast()).append("\n");
                    break;
            }
        }
        
        System.out.println(sb.toString());
    }
}