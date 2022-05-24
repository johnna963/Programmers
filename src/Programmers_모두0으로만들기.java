import java.util.ArrayList;

public class Programmers_모두0으로만들기 {
	/**
	 * */
	static class MakeAllZeros {
		static long answer;
		static boolean[] visited;
		static long[] arr;
		static ArrayList<Integer>[] graph;
	    public long solution(int[] a, int[][] edges) {
	        answer = 0;
	        visited = new boolean[a.length];
	        graph = new ArrayList[a.length];
	        arr = new long[a.length];
	        long sum = 0;
	        for (int i = 0; i < a.length; i++) {
				sum += a[i];
				graph[i] = new ArrayList<>();
				arr[i] = a[i];
			}
	        if(sum != 0) {
	        	return -1;
	        }
	        
	        for (int i = 0; i < edges.length; i++) {
				graph[edges[i][0]].add(edges[i][1]);
				graph[edges[i][1]].add(edges[i][0]);
			}
	        dfs(0);
	        return answer;
	    }
	    static long dfs(int v) {
	    	visited[v] = true;
	    	
	    	for (int i = 0; i < graph[v].size(); i++) {
				int next = graph[v].get(i);
				if(!visited[next]) {
					arr[v] += dfs(next);
				}
			}
	    	answer += Math.abs(arr[v]);
			return arr[v];
	    }
	}
	public static void main(String[] args) {
		MakeAllZeros sol = new MakeAllZeros();
		int[] a = {-5,0,2,1,2};
		int[][] edges = {{0,1},{3,4},{2,3},{0,3}};
		System.out.println(sol.solution(a, edges));
	}
}
