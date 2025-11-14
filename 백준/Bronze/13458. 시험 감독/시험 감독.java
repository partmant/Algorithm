import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[] applicants = new int[N];
        for (int i = 0; i < N; i++) 
            applicants[i] = sc.nextInt();
        
        int chiefCapacity = sc.nextInt();
        int subCapacity = sc.nextInt();
        
        long result = 0;
        for (int applicant : applicants) {
            result++;

            int rest = applicant  - chiefCapacity;
            if (rest > 0) {
                result += (rest + subCapacity - 1) / subCapacity;
            }
        }
        
        System.out.print(result);
    }
}