
public class Programmers_N으로표현 {
	static class ExpressedAsN {
		static int min = Integer.MAX_VALUE;
	    public int solution(int N, int number) {
	        int answer = 0;
	        DFS(0, N, number, 0);
	        
	        if(min==Integer.MAX_VALUE) {
	        	return -1;
	        }
	        return min;
	    }
	    static void DFS(int depth, int N, int number, int num) {
	    	if(depth> 8) {
	    		return;
	    	}
	    	if(num == number) {
	    		min = Math.min(depth, min);
	    		return;
	    	}
	    	int temp = 0;
	    	
	    	for (int i = 0; i < 8; i++) {
				if(depth + i < 8) {
					temp = temp * 10 + N;
					DFS(depth+i+1, N, number, num+temp);
					DFS(depth+i+1, N, number, num-temp);
					DFS(depth+i+1, N, number, num/temp);
					DFS(depth+i+1, N, number, num*temp);
				}
			}
	    }
	}
	public static void main(String[] args) {
		ExpressedAsN sol = new ExpressedAsN();
		int N = 5;
		int number = 12;
		sol.solution(N, number);
	}
}
