package programmers.level2;

import java.util.*;

public class 오픈채팅방 {

    /**
     * record	result
     * ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
     * ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
     */

    private static final String ENTER_COMMENT = "님이 들어왔습니다.";
    private static final String LEAVE_COMMENT = "님이 나갔습니다.";

    public String[] solution(String[] record) {

        Map<String, String> uidMap = new HashMap<>();
        List<String[]> list = new ArrayList<>();

        for (String log : record) {
            String[] info = log.split(" ");
            if (info.length == 3) {
                uidMap.put(info[1], info[2]); // uid, 이름
            }
            list.add(new String[] {info[1], info[0]}); // uid, 출입
        }
        List<String> answer = new ArrayList<>();
        for (String[] read : list) {
            if (read[1].equals("Enter")) {
                answer.add(uidMap.get(read[0]) + ENTER_COMMENT);
            } else if (read[1].equals("Leave")) {
                answer.add(uidMap.get(read[0]) + LEAVE_COMMENT);
            }
        }

        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        오픈채팅방 clazz = new 오픈채팅방();
        String[] str = clazz.solution(new String[] {
                "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"
        });
        System.out.println(str.toString());
    }
}
