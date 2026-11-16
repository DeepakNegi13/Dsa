package PrefixInfix;

import java.util.Stack;

public class prefixToInfix {
//    Prefix to Infix Algorithm
//    How It Works:
//    Scan the prefix expression from right to left (reverse order).
//
//    If the character is an operand, push it onto the stack.
//
//    If the character is an operator:
//
//    Pop two operands from the stack: op1 (top element) and op2 (second top element).
//
//    Combine them into an infix string: (op1 + operator + op2). Note the order: op1 comes first because we are reading right-to-left.
//
//    Push the resulting string back onto the stack.
//
//    At the end, the final element in the stack is the complete infix expression.
    public static String prefixToInfix(String prefix) {
        Stack<String> stack = new Stack<>();

        // Scan from right to left
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            // If operand, push to stack
            if (Character.isLetterOrDigit(c)) {
                stack.push(Character.toString(c));
            }
            // If operator, pop two operands and combine
            else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String expression = "" + op1 + c + op2 + "";
                stack.push(expression);
            }
        }

        // The stack's top contains the final infix expression
        return stack.peek();
    }
    public static void main(String[] args) {
        String prefix = "-+A*BC/DE";
        System.out.println("Prefix Expression: " + prefix);
        System.out.println("Infix Expression:  " + prefixToInfix(prefix));
    }
}
