import java.util.Arrays;

public class Programmers_입국심사 {
	/**
	 * 무엇을 분할해 탐색할까
	 * */
	static class Immigration {
	    public long solution(int n, int[] times) {
	        long answer = 0;
	        Arrays.sort(times);
	        long left = 0;
	        long right = (long)n * times[times.length-1];
	        while(left<=right) {
	        	long mid = (left + right)/2;
	        	long sum = 0;
	        	
	        	for (int i = 0; i < times.length; i++) {
					sum += mid/times[i];
				}
	        	
	        	if(sum<n) {
	        		left = mid + 1;
	        	}
	        	else {
	        		right = mid - 1;
	        		answer = mid;
	        	}
	        }
	        ///System.out.println(answer);
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Immigration sol = new Immigration();
		int n = 6;
		int[] times = {7,10};
		sol.solution(n, times);
	}

}
