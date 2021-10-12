package programmers.level1;

public class 핸드폰_번호_가리기 {
    public String solution(String phone_number) {
        return phone_number.replaceAll(".(?=.{4})", "*");
//        StringBuilder answer = new StringBuilder();
//        for (int i = 0; i < phone_number.length() - 4; i++) {
//            answer.append("*");
//        }
//        answer.append(phone_number.substring(phone_number.length() - 4));
//        return answer.toString();
    }
}
