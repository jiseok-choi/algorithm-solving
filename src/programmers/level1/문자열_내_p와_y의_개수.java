package programmers.level1; 

class 문자열_내_p와_y의_개수 {
    boolean solution(String s) {

        int cnt = 0;

        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'y') {
                cnt++;
            } else if (c == 'p') {
                cnt--;
            }
        }

        return cnt == 0;
    }
}
