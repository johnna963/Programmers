import java.util.Arrays;

public class Programmers_최솟값만들기 {
	static class CreateMinimumValue
	{
	    public int solution(int []A, int []B)
	    {
	        int answer = 0;
	        Arrays.sort(A);
	        Arrays.sort(B);
	        
	        for (int i = 0; i < B.length; i++) {
	        	answer += A[i] * B[A.length - 1 - i];
			}
	        return answer;
	    }
	}
	public static void main(String[] args) {
		CreateMinimumValue sol = new CreateMinimumValue();
		int[] A = {1,4,2};
		int[] B = {5,4,4};
		System.out.println(sol.solution(A, B));
		
	}
}
