import java.io.*;
import java.util.*;

public class Main {

    static class Lecture {
        int idx, s, e;
        Lecture(int idx, int s, int e) {
            this.idx = idx;
            this.s = s;
            this.e = e;
        }
    }

    static class Room {
        int end, roomNo;
        Room(int end, int roomNo) {
            this.end = end;
            this.roomNo = roomNo;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(n, s, e);
        }

        Arrays.sort(lectures, (a, b) -> {
            if (a.s != b.s) return a.s - b.s;
            return a.e - b.e;
        });

        PriorityQueue<Room> pq =
            new PriorityQueue<>(Comparator.comparing(r -> r.end));

        int roomCount = 1;
        int[] answer = new int[N + 1];

        for (Lecture lec : lectures) {
            if (!pq.isEmpty() && pq.peek().end <= lec.s) {
                Room prev = pq.poll();
                answer[lec.idx] = prev.roomNo;
                pq.add(new Room(lec.e, prev.roomNo));
            } else {
                answer[lec.idx] = roomCount;
                pq.add(new Room(lec.e, roomCount));
                roomCount++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(roomCount - 1).append('\n');
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.print(sb);
    }
}
