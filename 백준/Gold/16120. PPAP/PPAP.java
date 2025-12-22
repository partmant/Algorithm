import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int countP = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'P') {
                countP++;
            } else {
                if (countP < 2 || i + 1 >= s.length() || s.charAt(i + 1) != 'P') {
                    System.out.print("NP");
                    return;
                }
                
                countP--;
                i++;
            }
        }
        
        if (countP == 1) {
            System.out.print("PPAP");
        } else {
            System.out.print("NP");
        }
    }
}
