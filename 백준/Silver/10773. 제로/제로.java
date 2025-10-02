import java.util.*;
import java.io.*;

public class Main    {
    public static void main(String[] args) throws IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        
        for(int i=0;i<N;i++)    {
            int t = Integer.parseInt(br.readLine());
            
            if(t>0)    {   
                stack.push(t);
                result += t;
            }
            
            else if(t==0)    {
                result -= stack.pop(); 
            }
        } 
        
        System.out.println(result);
    }
}