package programmers.level1;

public class 평균_구하기 {
    public double solution(int[] arr) {
        double answer = 0;

        for (int num : arr) {
            answer += num;
        }

        return answer / arr.length;
    }
}
