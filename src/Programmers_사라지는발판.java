
public class Programmers_사라지는발판 {
	static class DisappearingScaffolding {
		static class Result{
			boolean win;
			int count;
			
			public Result(boolean win, int count) {
				this.win = win;
				this.count = count;
			}
		}
		public static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
		int board_row;
		int board_col;
	    public int solution(int[][] board, int[] aloc, int[] bloc) {
	        board_row = board.length;
	        board_col = board[0].length;
	        
	        return dfs(aloc[0], aloc[1], bloc[0], bloc[1], 0, board).count;
	    }
	    public Result dfs(int x1, int y1, int x2, int y2, int depth, int[][] board) {
			boolean win = false;
			int minCount = 5*5;
			int maxCount = depth;
			
			if(board[x1][y1] == 1) {
				for (int[] temp : dir) {
					int x1temp = x1 + temp[0];
					int y1temp = y1 + temp[1];
					if(isValid(x1temp, y1temp, board)) {
						board[x1][y1] = 0;
						
						Result d = dfs(x2,y2,x1temp,y1temp,depth + 1, board);
						win |= !d.win;
						if(!d.win) minCount = Math.min(minCount, d.count);
						else maxCount = Math.max(maxCount, d.count);
						
						board[x1][y1] = 1;
					}
				}
			}
	    	return new Result(win, win ? minCount : maxCount);
	    }
	    public boolean isValid(int x, int y, int[][] board) {
	    	if(x < 0 || x >= board_row || y<0 || y>=board_col||board[x][y] == 0) {
	    		return false;
	    	}
	    	return true;
	    }
	}
	public static void main(String[] args) {
		DisappearingScaffolding sol = new DisappearingScaffolding();
		int[][] board = {
				{1, 1, 1}, 
				{1, 1, 1}, 
				{1, 1, 1}
				};
		int[] aloc = {1, 0};
		int[] bloc = {1, 2};
		System.out.println(sol.solution(board, aloc, bloc));
	}

}
