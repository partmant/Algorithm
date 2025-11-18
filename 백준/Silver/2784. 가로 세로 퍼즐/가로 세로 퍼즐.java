import java.util.*;

public class Main {
	static String[] words = new String[6];
    static String[] rows = new String[3];
    static boolean[] used = new boolean[6];
    static boolean found = false;
	
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	
        for (int i = 0; i < 6; i++) {
            words[i] = sc.next();
        }

        Arrays.sort(words);

        backtrack(0);

        if (!found) {
            System.out.println(0);
        }
    }
	
	static void backtrack(int depth) {
        if (found) return;

        if (depth == 3) {
            checkSolution();
            return;
        }

        for (int i = 0; i < 6; i++) {
            if (!used[i]) {
                used[i] = true;
                rows[depth] = words[i];
                backtrack(depth + 1);
                used[i] = false;
            }
        }
    }
	
	static void checkSolution() {
        String r1 = rows[0];
        String r2 = rows[1];
        String r3 = rows[2];

        String c1 = "" + r1.charAt(0) + r2.charAt(0) + r3.charAt(0);
        String c2 = "" + r1.charAt(1) + r2.charAt(1) + r3.charAt(1);
        String c3 = "" + r1.charAt(2) + r2.charAt(2) + r3.charAt(2);

        ArrayList<String> remain = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            if (!used[i]) {
            	remain.add(words[i]);
            }
        }

        ArrayList<String> columns = new ArrayList<>(Arrays.asList(c1, c2, c3));

        Collections.sort(remain);
        Collections.sort(columns);

        if (remain.equals(columns)) {
            System.out.println(r1);
            System.out.println(r2);
            System.out.println(r3);
            found = true;
        }
    }
}
