import java.util.Arrays;
import java.util.HashSet;

public class Programmers_불량사용자 {
	static class BadUser {
		HashSet<String> set;
		String[] regex;
		String[] user;
		boolean[] visited;
	    public int solution(String[] user_id, String[] banned_id) {
	        int answer = 0;
	        set = new HashSet<>();
	        user  = user_id;
	        regex = new String[banned_id.length];
	        
	        for (int i = 0; i < banned_id.length; i++) {
				regex[i] = banned_id[i].replace("*", ".");
			}
	        
	        visited = new boolean[user.length];
	        backtracking(0,"");
	        answer = set.size();
	        return answer;
	    }
	    public void backtracking(int index, String result) {
	    	if(index == regex.length) {
	    		String[] str = result.split(" ");
	    		Arrays.sort(str);
	    		
	    		String newstr = "";
	    		for (int i = 0; i < str.length; i++) {
					newstr +=str[i];
				}
	    		set.add(newstr);
	    		return;
	    	}
	    	
	    	for (int i = 0; i < user.length; i++) {
				if(!visited[i] && user[i].matches(regex[index])) {
					visited[i] = true;
					backtracking(index+1, result+" "+ user[i]);
					visited[i] = false;
				}
			}
	    }
	}
	public static void main(String[] args) {
		BadUser sol = new BadUser();
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "abc1**"};
		System.out.println(sol.solution(user_id, banned_id));
	}
}
