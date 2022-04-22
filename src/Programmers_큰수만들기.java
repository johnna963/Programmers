
public class Programmers_큰수만들기 {
	static class MakingbigNumber {
	    public String solution(String number, int k) {
	    	StringBuilder sb = new StringBuilder();
	        int cnt = number.length() - k;
	        int left = 0;
	        int right = number.length() - cnt;
	        int max = -1;
	        int idx = 0;
	        while(cnt>0) {
	        	max = -1;
	        	for (int i = left; i <= right; i++) {
					int num = number.charAt(i) - '0';
					if(num > max) {
						idx = i;
						max = num;
					}
				}
	        	sb.append(number.charAt(idx));
	        	left = idx + 1;
	        	right = number.length() - --cnt;
	        }
	        return sb.toString();
	    }
	}
	public static void main(String[] args) {
		MakingbigNumber sol = new MakingbigNumber();
		String number= "1924";
		int k = 2;
		System.out.println(sol.solution(number, k));
	}

}
