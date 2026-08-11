class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int idx = 0; idx < schedules.length; idx++) {
            int hour = schedules[idx] / 100;
            int minute = schedules[idx] % 100;
            
            minute += 10;
            if (minute >= 60) {
                hour += 1;
                minute -= 60;
            }
            
            int schedule = hour * 100 + minute;
            boolean isLate = false;
            
            for (int day = 0; day < 7; day++) {
                int dayOfWeek = (startday + day - 1) % 7 + 1;
                
                if (dayOfWeek == 6 || dayOfWeek == 7) {
                    continue;
                }
                
                if (timelogs[idx][day] > schedule) {
                    isLate = true;
                    break;
                }
            }

            if (!isLate) answer++;
        }
        
        return answer;
    }
}
