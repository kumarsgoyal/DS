import java.util.*; 

/*
    In a party of N people, only one person is known to everyone. Such a person
    may be present in the party, if yes, (s)he doesn’t know anyone in the 
    party. We can only ask questions like “does A know B? “. Find the stranger
    (celebrity) in the minimum number of questions.

    We can describe the problem input as an array of numbers/characters 
    representing persons in the party. We also have a hypothetical function 
    HaveAcquaintance(A, B) which returns true if A knows B, false otherwise. 
    How can we solve the problem.
*/


  
class CelebrityProblem {

    public int celebrityProblem(int[][] arr, int n) { 
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            stk.push(i);
        }

        while(stk.size() > 1) {
            int a = stk.pop();
            int b = stk.pop();

            // if A know B then A is not celebrity 
            // but we are not sure about B
            if(arr[a][b] == 1) {
                stk.push(b);
            }
            else {
                stk.push(a);
            }
        }

        int c = stk.pop();

        for(int i = 0; i < n; i++) {
            if(arr[c][i] == 1) {
                return -1;
            }
        }

        return c;

    } 

    public static void main(String[] args) {  
        CelebrityProblem s = new CelebrityProblem();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        System.out.println("Enter elements");

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int num = sc.nextInt();
                arr[i][j] = num;
            }
        }

        System.out.println(s.celebrityProblem(arr, n));
    }  
};  
