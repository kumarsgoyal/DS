import java.util.*; 

// Design and Implement function to convert postfix to prefix
// input: ABC/-AK/L-*
// output:  *-A/BC-/AKL

/*

    postfix to infix to prefix is long process
	Steps:
	1) Read the Postfix expression from left to right
	2) If the symbol is an operand, then push it onto the Stack
	3) If the symbol is an operator, then pop two operands from the Stack
	4) Create a string by concatenating the two operands and the operator 
		before them.
	5) string = operator + operand2 + operand1
	6) And push the resultant string back to Stack
	7) Repeat the above steps until end of Prefix expression.
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

                res = c + b + a;
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
