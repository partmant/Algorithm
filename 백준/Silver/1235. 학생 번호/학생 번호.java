import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        String[] nums = new String[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.next();
        }
        
        int size = 1;
        while (true) {
            Set<String> set = new HashSet<>();
            boolean duplicate = false;
            
            for (int i = 0; i < N; i++) {
                String num = nums[i];
                String subNum = num.substring(num.length() - size);
                
                if (set.contains(subNum)) {
                    duplicate = true;
                    break;
                }
                
                set.add(subNum);
            }
            
            if (!duplicate) {
                System.out.print(size);
                break;
            }
            
            size++;
        }
    }
}
