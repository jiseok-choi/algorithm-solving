package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {

    static class Task {
        int priority;
        int location;
        public Task(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
    // 프린터
    public static int solution(int[] priorities, int location) {

        int now = 0;

        Queue<Task> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Task(priorities[i], i));
        }

        while (!queue.isEmpty()) {
            // 프린트 대상
            Task cur = queue.poll();

            boolean flag = false;
            for (Task t : queue) {
                if (t.priority > cur.priority) {
                    flag = true;
                }
            }
            if (flag) {
                queue.add(cur);
            } else {
                now++;
                if (cur.location == location) {
                    break;
                }
            }
        }
        return now;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 1, 9, 1, 1, 1}, 0));
    }
}
