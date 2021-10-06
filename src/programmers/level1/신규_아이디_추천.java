package programmers.level1;

public class 신규_아이디_추천 {
    private String[] symbols_all = {"-", "_", ".", "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "=", "+", "[", "{", "]", "}", ":", "?", ",", "<", ">", "/"};
    private static String[] SYMBOLS = {"~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "=", "+", "[", "{", "]", "}", ":", "?", ",", "<", ">", "/"};
    private static char[] SYMBOLS_CHAR = {'~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '=', '+', '[', '{', ']', '}', ':', '?', ',', '<', '>', '/'};

    private String new_id;

    public static String solution(String new_id) {

        // step 1 소문자변환
        new_id = new_id.toLowerCase();

        // step 2 특수 기호 제거
        for (int i = 0; i < SYMBOLS.length; i++) {
            new_id = new_id.replace(SYMBOLS[i], "");
        }

        // step 3 "." 줄이기
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1000; i >= 0; i--) {
//            sb.append(".");
//            new_id = new_id.replace(sb.toString(), ".");
//        }

        for (int i = 0; i < new_id.length(); i++) {
            if (new_id.charAt(i) == '.') {
                int j = i + 1;
                String dot = ".";

                while (j != new_id.length() && new_id.charAt(j) == '.') {
                    dot += ".";
                    j++;
                }

                if (dot.length() > 1)
                    new_id = new_id.replace(dot, ".");
            }
        }

        // step 4 첫과 끝 "." 없애기

        while (new_id.startsWith(".")) {
            new_id = new_id.substring(1, new_id.length());
        }
        while (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        // step 5 빈문자열일시 "a"
        if (new_id.length() == 0) {
            new_id = "a";
        }

        // step 6
        // 15자 줄이기
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        while (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }


        // step 7
        // 3이상 문자열 만들기
        String last = new_id.charAt(new_id.length() - 1) + "";
        if (new_id.length() == 2) {
            new_id = new_id + last;
        } else if (new_id.length() == 1) {
            new_id = new_id + last + last;
        }


        return new_id;
    }


    public static void main(String[] args) {
        System.out.println(solution("....!@BaT#*..y.....abcdefghijklm"));


    }
}
