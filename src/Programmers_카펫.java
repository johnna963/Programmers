

public class Programmers_카펫 {
	static class Carpet  {
	    public int[] solution(int brown, int yellow) {
	        int[] answer = new int[2];
	        int area = brown + yellow;
	        for(int i = 1; i <= area; i++){
	            int row = i;
	            int col = area/row;
	            if(row > col){
	                continue;
	            }
	            int center = (row - 2) * (col - 2);
	            if(center == yellow){
	                answer[0] = col;
	                answer[1] = row;
	                return answer;
	            }
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Carpet sol = new Carpet();
		int brown = 10;
		int yellow = 2;
		sol.solution(brown, yellow);
	}

}
