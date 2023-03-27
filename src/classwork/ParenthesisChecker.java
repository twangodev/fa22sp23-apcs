package classwork;

public class ParenthesisChecker {

    public static boolean checkParenthesis(String s) {

        String r = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                r += s.charAt(i);
            }
        }

        s = r;
        if (s.length() == 0) {
            return true;
        }

        char nextChar = s.charAt(0);
        char lastChar = s.charAt(s.length() - 1);

        if (nextChar == '(' && lastChar == ')') {
            return checkParenthesis(s.substring(1, s.length() - 1));
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkParenthesis("(() )"));
    }

}
