import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> openChar = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') openChar.push(')');
            else if (s.charAt(i) == '[') openChar.push(']');
            else if (s.charAt(i) == '{') openChar.push('}');
            else if (openChar.empty() || s.charAt(i) != openChar.peek()) return false;
            else openChar.pop();
        }
        return openChar.empty();
    }
}
