
public class Programmers_NQueen {
	static class NQueen {
	    static int[] col;
	    static int answer;
	    public int solution(int n) {
	        answer = 0;
	        col = new int[n];
	        backtracking(n,0);
	        return answer;
	    }
	    static void backtracking(int n, int depth){
	        if(depth == n){
	            answer++;
	            return;
	        }
	        for(int i = 0; i < n; i++){
	            col[depth] = i;
	            if(check(depth)){
	                backtracking(n,depth + 1);
	            }
	        }
	    }
	    static boolean check(int row){
	        for(int i = 0; i < row; i++){
	            if(col[row] == col[i]){
	                return false;
	            }
	            else if(Math.abs(row - i) == Math.abs(col[row] - col[i])){
	                return false;
	            }
	        }
	        return true;
	    }
	}
	public static void main(String[] args) {
		NQueen sol = new NQueen();
		int n = 4;
		sol.solution(n);
	}

}
