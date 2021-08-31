package programmers.level1;


/**
 * 네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
 *
 * 다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
 *
 * 1478 → "one4seveneight"
 * 234567 → "23four5six7"
 * 10203 → "1zerotwozero3"
 * 이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
 *
 * 참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.
 *
 * 숫자	영단어
 * 0	zero
 * 1	one
 * 2	two
 * 3	three
 * 4	four
 * 5	five
 * 6	six
 * 7	seven
 * 8	eight
 * 9	nine
 */
public class NumStringAndVoca {
    public static int solution(String s) {

        int[] num = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] strNum = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        s += "%";
        for (int i = 0; i < 10; i++) {
            String[] str = s.split(strNum[i]);

            StringBuilder tmpStr = new StringBuilder();
            for (int j = 0; j < str.length; j++) {
                tmpStr.append(str[j]);
                if (j != str.length-1)
                    tmpStr.append(num[i]);
            }
            s = tmpStr.toString();
        }

        return Integer.parseInt(s.split("%")[0]);
    }

    /**
     * 어려웠던점 : split 으로 문자열을 구분자가 끝에 위치해 있을때 배열의 길이는 줄어든다.
     * ex) String str = "str,";
     * str.split(","); -> [str]
     *
     * 놓쳤던점 : 임시 문자열을 다룰때는 StringBuilder 를 사용해야한다.
     */
    public static void main(String[] args) {
        System.out.println(solution("onetwo"));
    }
}
