package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 다트_게임 {
    public static int solution(String dartResult) {
        String[] sp = new String[] {"S", "D", "T", "*", "#"};
        String[] dartList = dartResult.split("");
        int answer = 0;

        List<Integer> total_score = new ArrayList<>();
        int score = 0;
        int index = 0;
        boolean flag = false;

        for (String dart : dartList) {

            if (flag) {
                index++;
                flag = false;
                continue;
            }

            switch (dart) {
                case "S" :
                    total_score.add(score);
                    break;
                case "D" :
                    total_score.add(score * score);
                    break;
                case "T" :
                    total_score.add(score * score * score);
                    break;
                case "*" :
                    total_score.set(total_score.size() - 1, (total_score.get(total_score.size()-1) * 2));
                    if (total_score.size() != 1)
                        total_score.set(total_score.size() - 2, (total_score.get(total_score.size()-2) * 2));
                    break;
                case "#" :
                    total_score.set(total_score.size()-1, total_score.get(total_score.size()-1) * -1);
                    break;
                default:
                    score = Integer.parseInt(dart);
                    if (score == 1 && index + 1 != dartList.length) {
                        if (dartList[index + 1].equals("0")) {
                            score = 10;
                            flag = true;
                        }
                    }
                    break;
            }
            index++;
        }

        for (int n : total_score) {
            answer += n;
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution("1D2S0T"));
    }
}
