import java.util.PriorityQueue;

/*
https://programmers.co.kr/learn/courses/30/lessons/42629?language=java
 */
class RamenFactory {
    int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        PriorityQueue<DateSupply> queue = new PriorityQueue<DateSupply>();

        for (int i = 0; i < dates.length; i++) {
            queue.offer(new DateSupply(dates[i], supplies[i]));
        }

        return answer;
    }

    class DateSupply {
        int date;
        int supply;

        DateSupply(int date, int supply) {
            this.date = date;
            this.supply = supply;
        }
    }
}
