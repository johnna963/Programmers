import java.util.Stack;

public class Programmers_올바른괄호 {
	static class Correctbrackets {
	    boolean solution(String s) {
	        boolean answer = true;
	        Stack<Character> st = new Stack<>();
	        for(int i = 0; i < s.length();i++){
	            if(!st.isEmpty() && s.charAt(i)==')') {
	            	st.pop();
	            }
	            else {
	            	st.push(s.charAt(i));
	            }
	        }
	        if(!st.isEmpty()) {
	        	answer = false;
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Correctbrackets sol = new Correctbrackets();
		String s = "()()";
		sol.solution(s);
	}
}
