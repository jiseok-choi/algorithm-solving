package programmers.level1;

public class 가운데_글자_가져오기 {
    public String solution(String s) {

        int center = s.length() / 2;
        if (center / 2 == 0) {
            return s.substring(center, center + 1);
        } else {
            return s.substring(center);
        }
    }
}
