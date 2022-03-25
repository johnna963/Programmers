import java.util.*;
public class Programmers_전력망을둘로나누기 {
	static class DivideThePowerGridIntoTwo{
	    public int solution(int n, int[][] wires) {
	        int answer = Integer.MAX_VALUE;
	        ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
	        for(int i = 0; i <= n; i++) {
	        	map.add(new ArrayList<Integer>());
	        }
	        int a = 0; 
	        int b = 0;
	        for(int[] wire : wires) {
	        	map.get(wire[0]).add(wire[1]);
	        	map.get(wire[1]).add(wire[0]);
	        }
	        for(int[] wire : wires) {
	        	int m1 = dfs(map, wire[0], wire[0], wire[1], new boolean[n+1]);
	        	answer = Math.min(Math.abs(n-m1-m1), answer);
	        }
	        
	        return answer;
	    }

		static int dfs(ArrayList<ArrayList<Integer>> map, int start, int i1, int i2, boolean[] visit) {
			if(visit[start]) {
				return 0;
			}
			visit[start] = true;
			int result = 1;
			ArrayList<Integer> list = map.get(start);
			for(int i : list) {
				if((start == i1 && i ==i2) || (start == i2) && i ==i1 )
					continue;
				result +=dfs(map,i,i1,i2,visit);
			}
			return result;
		}
	}
	public static void main(String[] args) {
		DivideThePowerGridIntoTwo sol = new DivideThePowerGridIntoTwo();
		int n = 9;
		int[][] wires={{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		sol.solution(n, wires);
	}

}
