import java.util.*; 

// Design and Implement function to convert Infix to Postfix
// input: *-A/BC-/AKL
// output:  ABC/-AK/L-*

/*

    prefix to infix to postfix is long process
	Steps:
	1) Read the Prefix expression in reverse order (from right to left)
    2) If the symbol is an operand, then push it onto the Stack
    3) If the symbol is an operator, then pop two operands from the Stack
    4) Create a string by concatenating the two operands and the operator 
        after them.
    5) string = operand1 + operand2 + operator
    6) And push the resultant string back to Stack
    7) Repeat the above steps until end of Prefix expression.
*/
  
class PrefixtoPostfix { 

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

    public String prefixtoPostfix(String str) { 
        Stack<String> stk = new Stack<>();
        for(int i = str.length() - 1; i >= 0; i--) {
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

                res = a + b + c;
                stk.push(res);
            }
            else {
                stk.push(c + "");
            }
        }

        return stk.pop();
    }  

    public static void main(String[] args) {  
        PrefixtoPostfix s = new PrefixtoPostfix();  
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
     	System.out.println("Infix to postfix expression:   \t" + s.prefixtoPostfix(str));
    }  
};  
