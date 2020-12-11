import java.util.*; 

// Design and Implement function to Evaluation of Postfix Expression


class EvaluationofPostfixExpression {

    
    public int evaluationofPostfixExpression(String str) { 
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(Character.isDigit(ch) == true) {
                stk.push(ch - '0');
            }
            else {

                if(stk.size() < 2) {
                    return -2;
                }
                int val1 = stk.pop();
                int val2 = stk.pop();
                switch(ch) {
                    case '+': 
                    stk.push(val2 + val1); 
                    break; 
                      
                    case '-': 
                    stk.push(val2 - val1); 
                    break; 
                      
                    case '/': 
                    stk.push(val2 / val1); 
                    break; 
                      
                    case '*': 
                    stk.push(val2 * val1); 
                    break; 
                }
            }
        }

        return stk.pop();

    } 

    public static void main(String[] args) {  
        EvaluationofPostfixExpression s = new EvaluationofPostfixExpression();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(s.evaluationofPostfixExpression(str));
    }  
};  
