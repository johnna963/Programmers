import java.util.*;
public class Programmers_없는숫자더하기 {
	static class AddNumberMissing {
	    public int solution(int[] numbers) {
	        int answer = 45;
	        Arrays.sort(numbers);
	        for(int i = 0 ; i < numbers.length;i++){
	            answer-=numbers[i];
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		AddNumberMissing sol = new AddNumberMissing();
		int[] numbers = {1,2,3,4,6,7,8,0};
		sol.solution(numbers);
	}
}
