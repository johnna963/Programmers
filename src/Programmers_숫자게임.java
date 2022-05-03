import java.util.Arrays;

public class Programmers_숫자게임 {
	
	static class NumberGame {
	    public int solution(int[] A, int[] B) {
	        int answer = 0;
	        Arrays.sort(A);
	        Arrays.sort(B);
	        int b_index = B.length - 1;
	        for (int a_index = A.length-1; a_index >= 0; a_index--) {
				if(B[b_index] > A[a_index]) {
					answer++;
					b_index--;
				}
			}
	        return answer;
	    }
	}
	public static void main(String[] args) {
		NumberGame sol = new NumberGame();
		int[] A = {5,1,3,7};
		int[] B = {2,2,6,8};
		System.out.println(sol.solution(A, B));	
	}
}
