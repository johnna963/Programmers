
public class Programmers_파괴되지않은건물 {
	static class UnbrokenBuilding {
	    public int solution(int[][] board, int[][] skill) {
	        int answer = 0;
	        int r = board.length;
	        int c = board[0].length;
	        int[][] prefix_arr = new int[r+1][c+1];
	        for (int[] row : skill) {
				int degree = 0;
				if(row[0] == 1) {
					degree = -row[5];
				}
				else {
					degree = row[5];
				}
				int r1 = row[1];
				int c1 = row[2];
				int r2 = row[3];
				int c2 = row[4];
				
				prefix_arr[r1][c1] += degree;
				prefix_arr[r2+1][c1] -= degree;
				prefix_arr[r1][c2+1] -= degree;
				prefix_arr[r2+1][c2+1] += degree;
	        }
				for (int j = 1; j < c; j++) {
					for (int i = 0; i < r; i++) {
						prefix_arr[i][j] += prefix_arr[i][j-1]; 
					}
				}
				for (int i = 1; i < r; i++) {
					for (int j = 0; j < c; j++) {
						prefix_arr[i][j] += prefix_arr[i-1][j]; 
					}
				}
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if(board[i][j] + prefix_arr[i][j]>0) {
							answer++;
						}
					}
				}
			
	        return answer;
	    }
	}
	public static void main(String[] args) {
		UnbrokenBuilding sol = new UnbrokenBuilding();
		int[][] board= {{5,5,5,5,5},
				{5,5,5,5,5},
				{5,5,5,5,5},
				{5,5,5,5,5}
		};
		int[][] skill= {
				{1,0,0,3,4,4},
				{1,2,0,2,3,2},
				{2,1,0,3,1,2},
				{1,0,1,3,3,1}
		};
		System.out.println(sol.solution(board, skill));
	}
}
