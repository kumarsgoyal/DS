import java.util.*; 

// Design and Implement function to convert prefix to infix
// input: *-A/BC-/AKL
// output: (A-(B/C))*((A/K)-L))

/*  
    Steps for prefix to infix
    1) Read the Prefix expression in reverse order (from right to left)
    2) If the symbol is an operand, then push it onto the Stack
    3) If the symbol is an operator, then pop two operands from the Stack
    4) Create a string by concatenating the two operands and the operator 
        between them.
    5) string = (operand1 + operator + operand2) And push the resultant string 
        back to Stack
    6) Repeat the above steps until end of Prefix expression.
*/
  
class PrefixtoInfix {  

    public boolean isOperator (char ch) {
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


    public String prefixtoInfix(String s1) {
        Stack<String> stk = new Stack<>();

        for(int i = s1.length() - 1; i >= 0; i--) {
            char c = s1.charAt(i);
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

                res = "(" + a + c + b + ")";
                stk.push(res);
            }
            else {
                stk.push(new String("" + c));
            }
        }

        return stk.pop();
    }

    public static void main(String[] args) {  
        PrefixtoInfix s = new PrefixtoInfix();  
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
     	System.out.println("Infix to postfix expression:   \t" + s.prefixtoInfix(str));
    }  
};  
