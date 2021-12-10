import java.util.*;

public class Programmers_빛의경로싸이클{
	static int R;
	static int C;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static boolean[][][] enter;
	static class LightPathCycle{
		public int[] solution(String[] grid) {
	        ArrayList<Integer> list = new ArrayList<>();
	        int[] answer;
	        R = grid.length;
	        C = grid[0].length();
	        enter = new boolean[R][C][4];
	        
	        for(int i = 0; i < R; i++){
	            for(int j = 0; j < C; j++){
	                for(int k = 0; k < 4; k++){
	                    if(!enter[i][j][k]){
	                        list.add(LightCycle(grid,i,j,k));
	                    }
	                }
	            }
	        }
	        Collections.sort(list);
	        answer = new int[list.size()];
	        for (int i = 0; i < list.size(); i++) {
				answer[i] = list.get(i);
				System.out.println(answer[i]);
			}
	        return answer;
	    }
	}
	static int LightCycle(String[] grid, int r, int c, int d){
        int cnt = 0;
        while(true){
            if(enter[r][c][d]){
                break;
            }
            cnt++;
            enter[r][c][d] = true;
            if(grid[r].charAt(c) == 'L'){
                d = (d + 3) % 4;
            }
            else if(grid[r].charAt(c) == 'R'){
                d = (d + 1) % 4;
            }
            r = (r + dr[d] + R) % R;
            c = (c + dc[d] + C) % C;
        }
        return cnt;
    }
	public static void main(String[] args) {
		LightPathCycle sol = new LightPathCycle();
		String[] grid = {"SL","LR"};
		sol.solution(grid);
	}

}
