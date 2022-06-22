
public class Programmers_음양더하기 {
	static class AddYinYang {
	    public int solution(int[] absolutes, boolean[] signs) {
	        int answer = 0;
	        
	        for (int i = 0; i < signs.length; i++) {
				if(signs[i]) {
					answer+=absolutes[i];
				}
				else {
					answer-=absolutes[i];
				}
			}
	        return answer;
	    }
	}
	public static void main(String[] args) {
		AddYinYang sol = new AddYinYang();
		int[] absolutes = {4,7,12};
		boolean[] signs = {true,false,true};
		sol.solution(absolutes, signs);
	}

}
