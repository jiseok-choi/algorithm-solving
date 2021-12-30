package programmers.level2;

import java.util.HashSet;

public class 해시_위장 {

    public int solution(String[][] clothes) {
        int answer = 0;

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < clothes.length; i++) {
            set.add(clothes[i][1]);
        }

        for (int i = 0; i < set.size(); i++) {
            
        }
        return answer;
    }
}
