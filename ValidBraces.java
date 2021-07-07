/*Write a function that takes a string of braces, and determines if the order of the braces is valid. It should return true if the string is valid, and false if it's invalid.

This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}.

All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.

What is considered Valid?
A string of braces is considered valid if all braces are matched with the correct brace.
*/

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
