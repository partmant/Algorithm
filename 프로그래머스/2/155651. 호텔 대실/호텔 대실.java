import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

	private static class Book {
		int start;
		int end;

		public Book(int s, int e) {
			this.start = s;
			this.end = e;
		}
	}

	public int solution(String[][] book_time) {
		Book[] books = new Book[book_time.length];

		for (int i = 0; i < books.length; i++) {
			String[] times = book_time[i];
			books[i] = new Book(timeToMinutes(times[0]), timeToMinutes(times[1]));
		}

		Arrays.sort(books, (a, b) -> {
			return a.start - b.start;
		});

		PriorityQueue<Book> pq = new PriorityQueue<>((a, b) -> {
			return a.end - b.end;
		});

		for (int i = 0; i < books.length; i++) {
			Book curr = books[i];
			
			if (pq.isEmpty()) {
				pq.add(curr);
				continue;
			}
			
			if (pq.peek().end + 10 <= curr.start) {
                pq.poll();
            }
			pq.add(curr);
		}
		
		return pq.size();
	}

	private int timeToMinutes(String time) {
		String[] parts = time.split(":");
		int hour = Integer.parseInt(parts[0]);
		int mitues = Integer.parseInt(parts[1]);
		return hour * 60 + mitues;
	}
}
