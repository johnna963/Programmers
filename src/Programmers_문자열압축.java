

public class Programmers_문자열압축 {
	
	static class StringCompression {
	    public int solution(String s) {
	        int answer = s.length();
	        int len = s.length();	
	        
	        for (int i = 1; i < len/2+1; i++) {
				int cnt = 1;
	        	String word = s.substring(0,i);
	        	String compression = "";
	        	String remain = "";
				for (int j = i; j < len; j+=i) {
					if(j+i>len) {
						remain = s.substring(j);
						continue;
					}
					if(word.equals(s.substring(j,j+i))) {
						cnt++;
					}
					else {
						compression += word;
						if(cnt!=1) {
							compression = Integer.toString(cnt) + compression;
						}
						word = s.substring(j,j+i);
						cnt = 1;
					}
				}
				compression += word + remain;
				if(cnt!=1) {
					compression = cnt + compression;
				}
				System.out.println(compression);
				answer = Math.min(answer, compression.length());
			}
	        System.out.println(answer);
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		StringCompression sol = new StringCompression();
		String s = "ababcdcdababcdcd"; 
		sol.solution(s);
	}

}
