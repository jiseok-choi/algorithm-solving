package programmers.level1;

public class 자릿수_더하기 {
    public int solution(int n) {
        int answer = 0;
        /**
         * 파싱 안하고 문제푸는 코드
         * while(true) {
         *             answer+=n%10;
         *             if(n<10)
         *                 break;
         *
         *             n=n/10;
         *         }
         */
        String stringN = String.valueOf(n);
        String[] num = stringN.split("");
        for (String nu : num) {
            answer += Integer.parseInt(nu);
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
