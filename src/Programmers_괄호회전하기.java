import java.util.Stack;

public class Programmers_괄호회전하기 {
	static class RotateParentheses {
		public int solution(String s) {
	        int answer = 0;
	        String newString = s;
	        for (int i = 0; i < s.length(); i++) {
				if(Check(newString)) {
					answer++;
				}
	        	newString = newString.substring(1,s.length()) + newString.charAt(0);
			}
	        
	        return answer;
	    }
		boolean Check(String str) {
			Stack<Character> st = new Stack<>();
			for (int i = 0; i < str.length(); i++) {
				if(st.isEmpty()) {
					st.push(str.charAt(i));
				}
				else {
					if(str.charAt(i)==']') {
						if(st.peek() == '[') {
							st.pop();
						}
						else {
							st.push(str.charAt(i));
						}
					}
					else if(str.charAt(i)==')') {
						if(st.peek() == '(') {
							st.pop();
						}
						else {
							st.push(str.charAt(i));
						}
					}
					else if(str.charAt(i)=='}') {
						if(st.peek() == '{') {
							st.pop();
						}
						else {
							st.push(str.charAt(i));
						}
					}
					else {
						st.push(str.charAt(i));
					}
				}
			}
			if(st.isEmpty()) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	public static void main(String[] args) {
		RotateParentheses sol = new RotateParentheses();
		String s = "[](){}";
		System.out.println(sol.solution(s));
	}

}
