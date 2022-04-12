
public class Programmers_합승택시요금 {
	static int[][] map;
	static int answer = Integer.MAX_VALUE;
	static class FareOfSharedTaxi {
	    public int solution(int n, int s, int a, int b, int[][] fares) {
	    	map = new int[n][n];
	    	
	    	for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = 20000000;
				}
				map[i][i] = 0;
			}
	    	
	    	for (int i = 0; i < fares.length; i++) {
				map[fares[i][0] - 1][fares[i][1] - 1] = fares[i][2];
				map[fares[i][1] - 1][fares[i][0] - 1] = fares[i][2];
			}
	    	
	    	for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					if(i == k) continue;
					for (int j = 0; j < n; j++) {
						if(j==k || i == j) continue;
						map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
					}
				}
			}
	    	for (int i = 0; i < n; i++) {
				int current = map[s-1][i] + map[i][a-1] + map[i][b-1];
				
				if(answer >= current) {
					answer = current;
				}
			}
	        return answer;
	    }
	}
	public static void main(String[] args) {
		FareOfSharedTaxi sol = new FareOfSharedTaxi();
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = {
				{4, 1, 10}, 
				{3, 5, 24}, 
				{5, 6, 2}, {3, 1, 41}, {5, 1, 24}, 
				{4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}
		};
		System.out.println(sol.solution(n, s, a, b, fares));
	}

}
