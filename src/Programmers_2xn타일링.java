
public class Programmers_2xn타일링 {
	static class nx2Tiling {
	    public int solution(int n) {
	        int answer = 0;
	        int[] dp = new int[60001]; 
	        dp[1] = 1;
	        dp[2] = 2;
	        for (int i = 3; i <= n; i++) {
				dp[i] = (dp[i-1]+dp[i-2]) % 1000000007;
			}
	        answer = dp[n];
	        return answer;
	    }
	}
	public static void main(String[] args) {
		nx2Tiling sol = new nx2Tiling();
		int n = 4;
		System.out.println(sol.solution(n ));
	}

}
