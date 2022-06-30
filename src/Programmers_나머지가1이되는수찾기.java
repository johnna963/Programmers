
public class Programmers_나머지가1이되는수찾기 {
	static class FindNumberRemainder1 {
	    public int solution(int n) {
	        int answer = 0;
	        for (int i = 2; i < n; i++) {
				if(n%i==1) {
					answer = i;
					return i;
				}
			}
	        return answer;
	    }
	}
	public static void main(String[] args) {
		FindNumberRemainder1 sol = new FindNumberRemainder1();
		int n = 10;
		sol.solution(n);
	}

}
