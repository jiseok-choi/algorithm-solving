package programmers.level1;

public class 두_정수_사이의_합 {
    public long solution(int a, int b) {

        long answer = 0;
        int startNum = Math.min(a, b);
        int endNum = Math.max(a, b);

        for (int i = startNum; i <= endNum; i++) {
            answer += i;
        }
        return answer;

        /*
        // 잘 푼 문제
        public long solution(int a, int b) {
            return sumAtoB(Math.min(a, b), Math.max(b, a));
        }

        private long sumAtoB(long a, long b) {
            return (b - a + 1) * (a + b) / 2;
        }
         */
    }
}
