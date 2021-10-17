package programmers.level1;

public class 소수_찾기 {

    /**
     * 소수 찾기
     * 문제 설명
     * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
     *
     * 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
     * (1은 소수가 아닙니다.)
     *
     * 제한 조건
     * n은 2이상 1000000이하의 자연수입니다.
     * 입출력 예
     * n	result
     * 10	4
     * 5	3
     * 입출력 예 설명
     * 입출력 예 #1
     * 1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환
     *
     * 입출력 예 #2
     * 1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환
     */
    public int solution4(int n) {
        int answer = 0;

//        for (int i = 2; i <= n; i++) {
//            int cnt = 0;
//            for (int j = 1; j <= i; j++) {
//                if (i % j == 0) {
//                    cnt++;
//                }
//            }
//            if (cnt <= 2) {
//                answer++;
//            }
//        }
        for (int j = 2; j <= n; j++) {
            for (int i=1; i*i<=j; ++i) {
                if (n%i == 0)
                    answer++;
            }
        }


        return answer;
    }

    public int solution5(int n) {

        if (n < 2) {
            return 0;
        }

        int answer = 0;

        // 에라토스테네스의 체로 구분할 배열
        // +1 한 이유는 숫자 그대로 인덱스를 잡기 위해서...
        // default false, 만약에 true 라면 소수가 아니거나 체크한 숫자
        boolean[] check = new boolean[n + 1];

        I: for (int i = 2; i <= n; i++) {

            if (!check[i]) {
                // 어떤 수의 제곱근 이하에서 소수가 되는지 판정이 된데...
                int sqrt = (int)Math.sqrt(i);
                for (int j = 2; j <= sqrt; j++) {
                    if (i % j == 0) {
                        // 소수가 아니다
                        continue I;
                    }
                }
                // 다돌았어 그럼 소수네?
                answer++;


                // 배수를 걸러주는게 핵심 - 에라토스테네스의 체의 핵심 논리임
                for (int j = i; j <= n; j+=i) {
                    check[j] = true;
                }

            }
        }
        return answer;
    }
}
