
public class Programmers_GPS {
	static class GPS {
	    static int INF = 99999999;
	    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
	        int answer = 0;
	        int[][] road = new int[n+1][n+1];
	        
	        for(int i = 0; i<edge_list.length; i++){
	            int start = edge_list[i][0];
	            int end = edge_list[i][1];
	            road[start][end] = 1; road[end][start] = 1;
	        }
	        int[][] dp = new int[k][n+1];
	        
	        for(int i = 0; i< k; i++){
	            for(int j = 0; j< n+1; j++){
	                dp[i][j] = INF;
	            }
	        }
	        dp[0][gps_log[0]] = 0;
	        
	        for(int i = 1; i < k; i++){
	            for(int j = 1; j < n+1; j++){
	                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
	                
	                for(int l = 1; l < n+1; l++){
	                    if(road[j][l] ==1 ){
	                        dp[i][j] = Math.min(dp[i][j], dp[i-1][l]);
	                    }
	                }
	                if(j != gps_log[i]){
	                    dp[i][j]++;
	                }
	            }
	        }
	        if(dp[k-1][gps_log[k-1]]<INF){
	            return dp[k-1][gps_log[k-1]];
	        }
	        else{
	            return -1;
	        }
	    }
	}
	public static void main(String[] args) {
		GPS sol = new GPS();
		int n = 7;
		int m = 10;
		int[][] edge_list= {
				{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}
		};
		int k = 6;
		int[] gps_log = {1, 2, 3, 3, 6, 7};
		System.out.println(sol.solution(n, m, edge_list, k, gps_log));
	}
}
