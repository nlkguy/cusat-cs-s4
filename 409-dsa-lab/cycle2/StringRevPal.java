import java.util.Stack;

public class StringRevPal {
    public static void main(String[] args) {
        String str = "mlayalam";
        checkPalindrome(str);
    }

    public static boolean checkPalindrome(String str){

        char[] chars = str.toCharArray();
        int length = chars.length;
        char[] reversedChars = new char[length];
        Stack<Character> stack = new Stack<>();
        Stack<Character> tempstack = new Stack<>();
        Stack<Character> revstack = new Stack<>();


        for (int i = 0; i < length; i++) {
            stack.push(chars[i]);
            tempstack.push(chars[i]);
        }

        for (int i = 0; i < length; i++) {
            reversedChars[i] = stack.pop();
            revstack.push(reversedChars[i]);
        }



        String revString = new String(reversedChars);
        System.out.println(revString);

        for (int i = 0; i < length; i++) {
            if(tempstack.pop()==revstack.pop()){
                continue;
            }else{
                System.out.println("Not a palindrome");
                return false;
            }
            
        }
        System.out.println("is a palindrome");
        return true;

        
    }
}
