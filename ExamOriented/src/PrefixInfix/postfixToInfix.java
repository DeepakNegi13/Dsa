package PrefixInfix;

import java.util.Stack;

public class postfixToInfix {
//    Postfix to Infix Algorithm
//    How It Works:
//    Scan the postfix expression from left to right.
//
//    If the character is an operand, push it onto the stack.
//
//    If the character is an operator:
//
//    Pop two operands from the stack: op2 (top element) and op1 (second top element).
//
//    Combine them into an infix string: (op1 + operator + op2).
//
//    Push the resulting string back onto the stack.
//
//    At the end, the only element left in the stack is the final infix expression.

    public static String postfixToInfix(String postfix) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            // If operand, push to stack
            if (Character.isLetterOrDigit(c)) {
                stack.push(Character.toString(c));
            }
            // If operator, pop two operands and combine
            else {
                String op2 = stack.pop();
                String op1 = stack.pop();
                String expression = "(" + op1 + c + op2 + ")";
                stack.push(expression);
            }
        }

        // The stack's top contains the final infix expression
        return stack.peek();
    }
    public static void main(String[] args) {
        String postfix = "AB*C+DE/-";
        System.out.println("Postfix Expression: " + postfix);
        System.out.println("Infix Expression:   " + postfixToInfix(postfix));
    }
}
