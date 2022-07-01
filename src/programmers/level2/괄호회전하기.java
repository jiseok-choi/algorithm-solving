package programmers.level2;

import java.util.Stack;

public class 괄호회전하기 {

    static class StackClazz {
        private final Stack<String> stack;

        public StackClazz() {
            this.stack = new Stack<>();
        }

        public void push(String str) {
            if (stack.isEmpty()) {
                stack.push(str);
                return;
            }
            String peek = stack.peek();
            if (str.equals(")") && peek.equals("(")) {
                stack.pop();
            } else if (str.equals("}") && peek.equals("{")) {
                stack.pop();
            } else if (str.equals("]") && peek.equals("[")) {
                stack.pop();
            } else {
                stack.push(str);
            }
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public void clear() {
            stack.clear();
        }

    }

    public int solution(String s) {

        int answer = 0;

        StackClazz stack = new StackClazz();

        String[] sList = s.split("");

        for (int i = 0; i < s.length(); i++) {
            int index = i;

            for (int j = 0; j < s.length(); j++) {
                if (index == s.length()) {
                    index = 0;
                }
                stack.push(sList[index]);
                index++;
            }

            if (stack.isEmpty()) {
                answer++;
            }
            stack.clear();
        }
        return answer;
    }

    public static void main(String[] args) {
        괄호회전하기 clazz = new 괄호회전하기();
        System.out.println(clazz.solution("[](){}"));
    }
    
}
