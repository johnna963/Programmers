
class Programmers_124나라의숫자 {
	/**
	 * 1 2 3 4 5 6 7 8 9
	 * 0 0 1 1 1 2 2 2 3
	 * 1 2 0 1 2 0 1 2 0
	 * 1 2 4 11 12 14 21 22 24
	 * */
	static class TheNumberOf124Countries {
	    public String solution(int n) {
	    	 String answer = "";
	    	 String[] arr = {"4","1","2"}; 
	    	 int num = n;
	    	 while(num > 0) {
	    		 int remain = num % 3;
	    		 num = num / 3;
	    		 if(remain == 0) {
	    			 num--;
	    		 }
	    		 answer = arr[remain] + answer;
	    	 }
	    	 System.out.println(answer);
	         return answer;
	    }
	}
	public static void main(String[] args) {
		TheNumberOf124Countries sol = new TheNumberOf124Countries();
		int n = 5;
		sol.solution(n);
	}

}
