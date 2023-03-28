package classwork;

public class ParenthesisChecker {

    public static boolean checkParenthesis(String s) {
        return checkParenthesisCounter(s, 0);
    }

    private static boolean checkParenthesisCounter(String s, int counter) {
        s = s.replaceAll("[^()]", "");
        if (s.isEmpty()) return counter == 0;

        if (s.charAt(0) == '(') {
            return checkParenthesisCounter(s.substring(1), counter + 1);
        }

        if (s.charAt(0) == ')') {
            return counter > 0 && checkParenthesisCounter(s.substring(1), counter - 1);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkParenthesis("sin (e() ) ("));
    }

}
