package PrefixInfix;
import java.util.Stack;

public class InfixToPrefixConverter {

    // Helper method to define operator precedence
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Helper method to convert an expression to Postfix
    private static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the scanned character is an operand, add it to output
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // If the scanned character is '(', push it to the stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is ')', pop and output from the stack 
            // until an '(' is encountered
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
            // An operator is encountered
            else {
                while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                // Handle right-associative operators like '^'
                while (!stack.isEmpty() && precedence(c) == precedence(stack.peek()) && c != '^') {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all remaining operators from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Main method to convert Infix to Prefix
    public static String infixToPrefix(String expression) {
        // Step 1: Reverse the infix expression and swap brackets
        StringBuilder sb = new StringBuilder(expression);
        sb.reverse();

        //swap bracket
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                sb.setCharAt(i, ')');
            } else if (sb.charAt(i) == ')') {
                sb.setCharAt(i, '(');
            }
        }

        //---***till now the input is reverse***---

        // Step 2: Get the postfix form of the modified expression
        String postfix = infixToPostfix(sb.toString());

        // Step 3: Reverse the postfix expression to get the prefix expression
        StringBuilder prefix = new StringBuilder(postfix);
        prefix.reverse();

        return prefix.toString();
    }

    // Test the implementation
    public static void main(String[] args) {
        String infixExpr = "A+B*C-D/E";
        System.out.println("Infix Expression:  " + infixExpr);
        System.out.println("Prefix Expression: " + infixToPrefix(infixExpr));
    }
}