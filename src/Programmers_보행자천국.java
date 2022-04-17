
public class Programmers_보행자천국 {
	static class PedestrianParadise {
	    int MOD = 20170805;
	    
	    public int solution(int m, int n, int[][] cityMap) {
	        int answer = 0;
	        int[][][] dp = new int[m+1][n+1][2];
	        dp[1][1][0] = 1;
	        dp[1][1][1] = 1;
	        
	        for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					if(cityMap[i-1][j-1] == 0) {
						dp[i][j][0] += (dp[i - 1][j][0] + dp[i][j - 1][1]) % MOD;
						dp[i][j][1] += (dp[i - 1][j][0] + dp[i][j - 1][1]) % MOD;
					}
					else if(cityMap[i-1][j-1] == 1) {
						dp[i][j][0] = 0;
						dp[i][j][1] = 0;
					} else {
						dp[i][j][0] = dp[i-1][j][0];
						dp[i][j][1] = dp[i][j-1][1];
					}
				}
			}
	        answer = dp[m][n][0];
	        return answer;
	    }
	}
	public static void main(String[] args) {
		PedestrianParadise sol = new PedestrianParadise();
		int m = 3;
		int n = 3;
		int[][] cityMap = {
				{0, 0, 0}, {0, 0, 0}, {0, 0, 0}
		};
		System.out.println(sol.solution(m, n, cityMap));
	}
}
