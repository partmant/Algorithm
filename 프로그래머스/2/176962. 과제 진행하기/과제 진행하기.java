import java.util.*;

class Solution {
    static class Task {
        String name;
        int start;
        int remainingTime;

        Task(String name, int start, int remainingTime) {
            this.name = name;
            this.start = start;
            this.remainingTime = remainingTime;
        }
    }

    public String[] solution(String[][] plans) {
        List<Task> tasks = new ArrayList<>();
        for (String[] p : plans) {
            tasks.add(new Task(p[0], convertToMin(p[1]), Integer.parseInt(p[2])));
        }
        
        tasks.sort((a, b) -> a.start - b.start);

        Stack<Task> stoppedTasks = new Stack<>();
        List<String> answer = new ArrayList<>();
        
        int currentTime = 0;

        for (int i = 0; i < tasks.size(); i++) {
            Task current = tasks.get(i);
            
            while (!stoppedTasks.isEmpty() && currentTime < current.start) {
                Task paused = stoppedTasks.pop();
                int gap = current.start - currentTime;

                if (paused.remainingTime <= gap) {
                    currentTime += paused.remainingTime;
                    answer.add(paused.name);
                } else {
                    paused.remainingTime -= gap;
                    stoppedTasks.push(paused);
                    currentTime = current.start;
                }
            }

            currentTime = current.start;
            
            if (i < tasks.size() - 1) {
                Task next = tasks.get(i + 1);
                if (currentTime + current.remainingTime <= next.start) {
                    currentTime += current.remainingTime;
                    answer.add(current.name);
                } else {
                    current.remainingTime -= (next.start - currentTime);
                    stoppedTasks.push(current);
                    currentTime = next.start;
                }
            } else {
                answer.add(current.name);
            }
        }

        while (!stoppedTasks.isEmpty()) {
            answer.add(stoppedTasks.pop().name);
        }

        return answer.toArray(new String[0]);
    }

    private int convertToMin(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}
