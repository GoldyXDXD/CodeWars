import java.util.Stack;

public class BraceChecker {
    public boolean isValid(String braces) {
        String[] stringArray = braces.split("");
        Stack<String> stack = new Stack<>();
        for(String singleCharacter : stringArray) {
            if(singleCharacter.equals("(") || singleCharacter.equals("{") || singleCharacter.equals("[")) {
                stack.push(i);
            }
            else {
                if(stack.empty()) {
                    return false;
                }
                if(singleCharacter.equals("]")&& stack.peek().equals("[")) {
                    stack.pop();
                    continue;
                }
                if(singleCharacter.equals(")")&& stack.peek().equals("(")) {
                    stack.pop();
                    continue;
                }
                if(singleCharacter.equals("}")&& stack.peek().equals("{")) {
                    stack.pop();
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        return (stack.empty());
    }
}
