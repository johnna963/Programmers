

import java.util.Stack;

public class Programmers_괄호변환 {
	static class Solution {
	    public String solution(String p) {
	        if(check(p)) {
	        	return p;
	        }
	        return dfs(p);
	    }
	}
	static boolean check(String p) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if(c == '(') {
				stack.add(c);
			}
			else {
				if(stack.empty()) {
					return false;
				}
				else {
					stack.pop();	
				}
			}
		}
		if(stack.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	static String dfs(String p) {
		String u = "";
		String v = "";
		int cnt1 = 0;
		int cnt2 = 0;
		for(int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if(c=='(') {
				cnt1++;
			}else {
				cnt2++;
			}
			if((cnt1 != 0 && cnt2 !=0) && cnt1 == cnt2) {
				u = p.substring(0,i + 1);
				if(i != p.length() - 1) {
					v = p.substring(i + 1, p.length());
				}
				break;
			}
		}
		if(!check(u)) {
			String temp = "(" + dfs(v) + ")";
			u = u.substring(1,u.length() - 1);
			u = u.replace("(", ".");
			u = u.replace(")", "(");
			u = u.replace(".", ")");
			temp += u;
			return temp;
		}
		else {
			return u + dfs(v);
		}
		
	}
	public static void main(String[] args) {

	}

}
