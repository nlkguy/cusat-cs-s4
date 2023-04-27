import java.util.Stack;
import java.util.Scanner;

public class InfixToPostfix {

    public static String infixToPostfix(String infix) {
        // create a stack to hold operators
        Stack<Character> operatorStack = new Stack<>();
        // create a StringBuilder to hold postfix expression
        StringBuilder postfix = new StringBuilder();
        // loop through the infix expression
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            // if the character is a letter or digit, append it to the postfix expression
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }
            // if the character is an opening parenthesis, push it onto the stack
            else if (ch == '(') {
                operatorStack.push(ch);
            }
            // if the character is a closing parenthesis, pop operators from the stack and append them to the postfix expression until the opening parenthesis is found
            else if (ch == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                // remove the opening parenthesis from the stack
                operatorStack.pop();
            }
            // if the character is an operator, pop operators from the stack and append them to the postfix expression until an operator with lower precedence is found, then push the current operator onto the stack
            else {
                while (!operatorStack.isEmpty() && precedence(ch) <= precedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(ch);
            }
        }
        // pop any remaining operators from the stack and append them to the postfix expression
        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }
        return postfix.toString();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        String postfix = infixToPostfix(infix);
        System.out.println(postfix); // output: abcd^e-fgh*+^*+i-

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the infix expression: ");
        String exp = scanner.nextLine();

        String result = infixToPostfix(exp);
        System.out.println("Postfix expression: " + result);
    }
}
