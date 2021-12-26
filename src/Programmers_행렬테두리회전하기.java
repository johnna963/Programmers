
public class Programmers_행렬테두리회전하기 {
	static class RotatingBorderMatrix {
	    public int[] solution(int rows, int columns, int[][] queries) {
	        int[] answer = new int[queries.length];
	        int[][] map = new int[rows][columns];
	        for(int i = 0; i < rows; i++){
	            for(int j = 0; j < columns; j++){
	                map[i][j] = columns * i + j + 1;
	            }       
	        }
//	        for(int i = 0; i < rows; i++){
//	            for(int j = 0; j < columns; j++){
//	                System.out.print(map[i][j]+" ");
//	            }
//	            System.out.println();
//	        }
	        for(int i = 0; i < queries.length; i++){
	            answer[i] = rotate(map, queries[i][0],queries[i][1],queries[i][2],queries[i][3]);
	        }
	        return answer;
	    }
	    static int rotate(int[][] map, int r1, int c1, int r2, int c2){
	    	r1--;
		    r2--;
		    c1--;
		    c2--;
	        int temp = map[r1][c1];
	        int min = temp;
	        for(int i = r1; i < r2; i++){
	            map[i][c1] = map[i + 1][c1];
	            min = Math.min(min, map[i][c1]);
	        }
	        for(int i = c1; i < c2; i++){
	            map[r2][i] = map[r2][i + 1];
	            min = Math.min(min, map[r2][i]);
	        }
	        for(int i = r2; i > r1; i--){
	            map[i][c2] = map[i - 1][c2];
	            min = Math.min(min, map[i][c2]);
	        }
	        for(int i = c2; i > c1; i--){
	            map[r1][i] = map[r1][i - 1];
	            min = Math.min(min, map[r1][i]);
	        }
	        map[r1][c1 + 1] = temp;
	        return min;
	    }
	}
	public static void main(String[] args) {
		RotatingBorderMatrix sol = new RotatingBorderMatrix();
		int rows = 6;
		int columns = 6;
		int[][] queries = {
				{2,2,5,4},{3,3,6,6},{5,1,6,3}
		};
		sol.solution(rows, columns, queries);
	}

}
