import java.util.Stack;

class PrefixToPostfix {
    public static String prefixToPostfix(String prefixExpression) {
        Stack<String> stack = new Stack<String>();

        // Scan the prefix expression from right to left
        for (int i = prefixExpression.length() - 1; i >= 0; i--) {
            char ch = prefixExpression.charAt(i);

            // If the character is an operand, push it onto the stack
            if (Character.isLetterOrDigit(ch)) {
                stack.push(Character.toString(ch));
            }
            // If the character is an operator, pop two operands from the stack and concatenate them with the operator in between
            else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String result = op1 + op2 + ch;
                stack.push(result);
            }
        }

        // The final postfix expression is the top element of the stack
        String postfixExpression = stack.pop();
        return postfixExpression;
    }

    public static void main(String[] args) {
        String prefixExpression = "*+AB-CD";
        String postfixExpression = prefixToPostfix(prefixExpression);
        System.out.println(postfixExpression); // Output: AB+CD-*
    }
}


