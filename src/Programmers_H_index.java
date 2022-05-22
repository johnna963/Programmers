import java.util.Arrays;

public class Programmers_H_index {
	static class H_index {
	    public int solution(int[] citations) {
	        int answer = 0;
	        Arrays.sort(citations);
	        
	        for (int i = 0; i < citations.length; i++) {
				int hindex = citations.length - i;
				if(citations[i]>=hindex) {
					answer = hindex;
					break;
				}
			}
	        return answer;
	    }
	} 
	public static void main(String[] args) {
		H_index sol = new H_index();
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(sol.solution(citations));
	}
}
