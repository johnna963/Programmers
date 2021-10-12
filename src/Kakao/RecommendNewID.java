package Kakao;

public class RecommendNewID {	
	static class recommendnewid {
	    public String solution(String new_id) {
	        String answer = "";
	        //step1
	        String step1 = new_id.toLowerCase();
	        //step2
	        String step2 = "";
	        for (int i = 0; i < step1.length(); i++) {
				char c = step1.charAt(i);
				if((c>='a' && c<='z') || 
					(c>='0' && c<='9') ||
					c == '.'||c == '_'||c == '-') {
					step2+=c;
				}	
			}
	        //step3
	        String step3 = step2.toString();
	        while(step3.contains("..")) {
	        	step3 = step3.replace("..", ".");
	        }
	        //step4
	        String step4 = step3;
	        if(step4.length()>0) {
	        	if(step4.charAt(0)=='.') {
	        		step4 = step4.substring(1,step4.length());
	        	}
	        }
	        if(step4.length()>0) {
	        	if(step4.charAt(step4.length()-1) == '.') {
	        		step4 = step4.substring(0, step4.length()-1);
	        	}
	        }
	        //step5
	        String step5 = step4;
	        if(step5.equals("")) {
	        	step5 = "a";
	        }
	        //step6
	        String step6 = step5;
	        if(step6.length() >= 16) {
	        	step6 = step6.substring(0,15);
	        	if(step6.charAt(step6.length()-1)=='.') {
	        		step6 = step6.substring(0,step6.length()-1);
	        	}
	        }
	        //step7
	        String step7 = step6;
	        if(step7.length() <= 2) {
	        	char c = step7.charAt(step7.length()-1);
	        	
	        	while(step7.length()<3) {
	        		step7 += c;
	        	}
	        }
	        answer = step7;
	        System.out.println(answer);
	        return answer;
	    }
	}
	public static void main(String[] args) {
		recommendnewid sol = new recommendnewid();
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		sol.solution(new_id);
	}

}
