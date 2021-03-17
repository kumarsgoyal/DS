import java.util.*; 

// Design and Implement function to convert postfix to infix
// input: ABC/-AK/L-*
// output:  ((A-(B/C))*((A/K)-L))

/*

	Steps:
    1.While there are input symbol left
        1.1 Read the next symbol from the input.
    2.If the symbol is an operand
        2.1 Push it onto the stack.
    3.Otherwise,
        3.1 the symbol is an operator.
        3.2 Pop the top 2 values from the stack.
        3.3 Put the operator, with the values as arguments and form a string.
        3.4 Push the resulted string back to stack.
    4.If there is only one value in the stack
        4.1 That value in the stack is the desired infix string.
*/
  
class PostfixtoPrefix { 

    public boolean isOperator(char ch) {
        switch(ch) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return true;
        }

        return false;
    } 

    public String postfixtoPrefix(String str) { 
        Stack<String> stk = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(isOperator(c) == true) {
                String a, b, res;
                if(stk.isEmpty() == false) {
                    a = stk.pop();
                }
                else {
                    return "Invalid Expression";
                }
                if(stk.isEmpty() == false) {
                    b = stk.pop();
                }
                else {
                    return "Invalid Expression";
                }

                res = "(" + b + c + a + ")";
                stk.push(res);
            }
            else {
                stk.push(c + "");
            }
        }

        return stk.pop();
    }  

    public static void main(String[] args) {  
        PostfixtoPrefix s = new PostfixtoPrefix();  
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
     	System.out.println("Infix to postfix expression:   \t" + s.postfixtoPrefix(str));
    }  
};  
