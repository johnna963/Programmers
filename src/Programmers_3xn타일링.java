
public class Programmers_3xn타일링 {
	static class nx3Tiling {
	    public int solution(int n) {
	        int answer = 0;
	        int mod = 1000000007;
	        int[] dp = new int[n+1];
	        dp[1] = 2;
	        dp[2] = 3;
	        for (int i = 3; i <= n; i++) {
				if(i%2 == 0) {
					dp[i] = dp[i-1] + dp[i-2];
				}
				else {
					dp[i] = dp[i-1] * 2 + dp[i-2];
				}
				dp[i] =dp[i]%mod;
			}
	        answer = dp[n];
	        return answer;
	    }
	}
	public static void main(String[] args) {
		nx3Tiling sol = new nx3Tiling();
		int n = 4;
		System.out.println(sol.solution(n));
	}
}
