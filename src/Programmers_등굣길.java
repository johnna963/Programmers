

public class Programmers_등굣길 {
	static class WayToSchool {
	    public int solution(int m, int n, int[][] puddles) {
	        int answer = 0;
	        int[][] map = new int[n][m];;
	        for (int[] puddle : puddles)
	            map[puddle[1] - 1][puddle[0] - 1] = -1;
	        map[0][0] = 1;
	        
	        for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(map[i][j] == -1) {
						map[i][j] = 0;
						continue;
					}
					
					if(i!=0) {
						
						map[i][j] += map[i-1][j] % 1000000007;
					}
					if(j!=0) {
						
						map[i][j] += map[i][j-1] % 1000000007;
					}
				}
			}
	        return map[n-1][m-1] % 1000000007;
	    }
	}

	public static void main(String[] args) {
		WayToSchool sol = new WayToSchool();
		int m = 4;
		int n = 3;
		int[][] puddles = {{2,2}};
		System.out.println(sol.solution(m, n, puddles));
	}
}
