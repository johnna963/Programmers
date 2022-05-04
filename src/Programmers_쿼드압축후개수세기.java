
public class Programmers_쿼드압축후개수세기 {
	static int[] answer;
	static class CountAfterQuadCompression {
	    public int[] solution(int[][] arr) {
	        answer = new int[2]; 
	        divide(arr,0,0,arr.length); 
	        return answer;
	    }
	    static boolean check(int[][] arr, int x, int y, int size, int val) {
	    	for (int i = x; i < x+size; i++) {
				for (int j = y; j < y+size; j++) {
					if(arr[i][j]!=val)
					{
						return false;
					}
				}
			}
	    	return true;
	    }
	    static void divide(int[][] arr , int x, int y, int size) {
	    	if(check(arr,x,y,size, arr[x][y])){
	            if(arr[x][y] == 1)
	                answer[1]++;
	            else answer[0]++;
	            return ;
	        }
	    	
	    	divide(arr, x, y, size/2);
	    	divide(arr, x, y+size/2, size/2);
	    	divide(arr, x+size/2, y, size/2);
	    	divide(arr, x+size/2, y+size/2, size/2);
	    }
	}
	public static void main(String[] args) {
		CountAfterQuadCompression sol = new CountAfterQuadCompression();
		int[][] arr= {
			{1,1,0,0},
			{1,0,0,0},
			{1,0,0,1},
			{1,1,1,1}
		};
		sol.solution(arr);
	}
}
