
public class Programmers_땅따먹기 {
	/**
	 * 브루스포트로 푸니까 시간초과만 뜸
	 * dp문제인가보다*/
	static class Ddangddaemokgi {
	    int solution(int[][] land) {
	        int answer = 0;
	        int n = land.length;
	        for(int i = 1; i < n; i++){
	            land[i][0] += Math.max(Math.max(land[i-1][1],land[i-1][2]),land[i-1][3]);
	            land[i][1] += Math.max(Math.max(land[i-1][0],land[i-1][2]),land[i-1][3]);
	            land[i][2] += Math.max(Math.max(land[i-1][1],land[i-1][0]),land[i-1][3]);
	            land[i][3] += Math.max(Math.max(land[i-1][1],land[i-1][2]),land[i-1][0]);
	        }
	        answer = Math.max(Math.max(land[n-1][0],land[n-1][1]), Math.max(land[n-1][2],land[n-1][3]));
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Ddangddaemokgi sol = new Ddangddaemokgi();
		int[][] land = {
				{1,2,3,5},{5,6,7,8},{4,3,2,1}
		};
		sol.solution(land );
	}
}
