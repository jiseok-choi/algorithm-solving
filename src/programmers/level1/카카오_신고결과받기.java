package programmers.level1;

import java.util.*;

public class 카카오_신고결과받기 {

    /**
     * id_list	report	k	result
     * ["muzi", "frodo", "apeach", "neo"]	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	2	[2,1,1,0]
     * ["con", "ryan"]	["ryan con", "ryan con", "ryan con", "ryan con"]	3	[0,0]
     * @param id_list
     * @param report
     * @param k
     * @return
     */
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Set<String> distinct = new HashSet<>(Arrays.asList(report)); // 신고 목록 중복제거

        Map<String, Integer> declarationCount = new HashMap<>(); // 신고자 신고 개수
        Map<String, List<String>> subject = new HashMap<>(); // 신고받은 사람별 신고자들
        Map<String, Integer> answerMap = new HashMap<>(); // 사람별 메일 받은 개수

        // 초기화
        for (String content : distinct) {
            String[] names = content.split(" ");
            Integer targetCnt = declarationCount.get(names[1]);
            declarationCount.put(names[1], targetCnt == null ? 1 : targetCnt + 1);

            List<String> subList = subject.get(names[1]) == null ? new ArrayList<>() : subject.get(names[1]);
            subList.add(names[0]);
            subject.put(names[1], subList);
        }

        // 메일 개수 채우기
        for (String answerName : id_list) {
            if (subject.get(answerName) != null) {
                subject.get(answerName).forEach(sub -> {
                    Integer answerCnt = answerMap.get(sub);
                    if (declarationCount.get(answerName) >= k) {
                        answerMap.put(sub, answerCnt == null ? 1 : answerCnt + 1);
                    }
                });
            }
        }

        // 결과 담기
        for (int i = 0; i < id_list.length; i++) {
            Integer count = answerMap.get(id_list[i]);
            answer[i] = count == null ? 0 : count;
        }

        return answer;
    }

    public static void main(String[] args) {
        카카오_신고결과받기 kakao = new 카카오_신고결과받기();
        Arrays.stream(kakao.solution(
                Arrays.asList("muzi", "frodo", "apeach", "neo").toArray(new String[4]),
                Arrays.asList("apeach muzi", "muzi frodo","apeach frodo","frodo neo","muzi neo").toArray(new String[5]),
                2
        )).forEach(System.out::println);
    }

}
