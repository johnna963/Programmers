import java.util.*;

public class Programmers_경주로건설 {
	static class ConstructionofRaceway {
		
	    public int solution(int[][] board) {
	    	 int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
	         int N = board.length;

	         int[][][] cost = new int[N][N][4];
	         for (int i = 0; i < N; i++)
	             for (int j = 0; j < N; j++)
	                 Arrays.fill(cost[i][j], Integer.MAX_VALUE);

	         Queue<int[]> queue = new LinkedList<>();
	         queue.add(new int[]{0, 0, 0, 1});
	         queue.add(new int[]{0, 0, 0, 3});

	         while (!queue.isEmpty()) {
	             int[] cur = queue.poll();

	             for (int k = 0; k < 4; k++) {
	                 int ny = cur[0] + dy[k], nx = cur[1] + dx[k];
	                 int c = cur[2] + (cur[3] == k ? 100 : 600);

	                 if (ny < 0 || nx < 0 || ny >= N || nx >= N || board[ny][nx] == 1 || cost[ny][nx][k] <= c) continue;
	                 cost[ny][nx][k] = c;
	                 queue.add(new int[]{ny, nx, c, k});
	             }
	         }

	         return Arrays.stream(cost[N - 1][N - 1]).min().getAsInt();
	    }
	    
	}
	public static void main(String[] args) {
		ConstructionofRaceway sol = new ConstructionofRaceway();
		int[][] board = {
				{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},
				{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}
		};
		System.out.println(sol.solution(board));
		sol.solution(board);
	}
}
