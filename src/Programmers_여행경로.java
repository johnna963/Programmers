
import java.util.ArrayList;
import java.util.Collections;

public class Programmers_여행경로 {
	static class TravelRoute {
		static String path="";
		static ArrayList<String> list = new ArrayList<>();
		static boolean[] visited;
	    public String[] solution(String[][] tickets) {
	        String[] answer;
	        
	        for (int i = 0; i < tickets.length; i++) {
	        	visited = new boolean[tickets.length];
				String from = tickets[i][0];
				String to = tickets[i][1];
				if(from.equals("ICN")) {
					path = from +",";
					visited[i] = true;
					dfs(tickets, to, 1);
				}
			}
	        Collections.sort(list);
	        System.out.println(list.get(0));
	        answer = list.get(0).split(",");
	        return answer;
	    }
	    static void dfs(String[][] tickets, String to, int cnt) {
	    	path += to +",";
	    	if(cnt == tickets.length) {
	    		list.add(path);
	    		return;
	    	}
	    	for (int i = 0; i < tickets.length; i++) {
				String f = tickets[i][0];
				String t = tickets[i][1];
				if(f.equals(to) && ! visited[i]) {
					visited[i] = true;
					dfs(tickets, t, cnt + 1);
					visited[i] = false;
					path = path.substring(0,path.length() - 4);
				}
			}
	    }
	}
	public static void main(String[] args) {
		TravelRoute sol = new TravelRoute();
		
		String[][] tickets = {{"ICN", "SFO"},
								{"ICN", "ATL"},
								{"SFO", "ATL"},
								{"ATL", "ICN"},
								{"ATL","SFO"}};
		
		sol.solution(tickets);
	}

}
