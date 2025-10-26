import java.util.*;
import java.io.*;

public class Main    {
    public static void main(String[] args) throws IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> freq = new HashMap<>();
        int[] numbers = new int[N];
        int[] result = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)    {
            numbers[i] = Integer.parseInt(st.nextToken());
            freq.put(numbers[i], freq.getOrDefault(numbers[i], 0) + 1);
        }

        for(int i=0;i<N;i++)    {
            while(!stack.isEmpty() && freq.get(numbers[stack.peek()]) < freq.get(numbers[i]))
                result[stack.pop()] = numbers[i];
            
            stack.push(i);
        }
        
        while(!stack.isEmpty())
            result[stack.pop()] = -1;
        
        for(int i:result)
            sb.append(i).append(" ");

        System.out.println(sb);
    }
}