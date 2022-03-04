import java.util.*;
public class Programmers_가장먼노드 {
	static class TheFarthestNode {
	    static boolean[] visited;
	    static ArrayList<Integer>[] graph;
	    static int[] dist;
	    static int Max = Integer.MIN_VALUE;
	    public int solution(int n, int[][] edge) {
	        int answer = 0;
	        graph = new ArrayList[n+1];
	        dist = new int[n+1];
	        visited = new boolean[n+1];
	        for(int i = 1; i <= n; i++){
	            graph[i] = new ArrayList<>();
	        }
	        for(int i = 0; i < edge.length; i++){
	            graph[edge[i][0]].add(edge[i][1]);
	            graph[edge[i][1]].add(edge[i][0]);
	        }
	        
	        bfs();
	        
	        for(int i = 1; i <= n; i++){
	            if(Max == dist[i]){
	                answer++;
	            }
	        }
	        return answer;
	    }
	    static void bfs(){
	        Queue<Integer> queue = new LinkedList<>();
	        queue.add(1);
	        visited[1] = true;
	        dist[1] = 0;
	        
	        while(!queue.isEmpty()){
	            int v = queue.poll();
	            
	            for(int i = 0; i < graph[v].size(); i++){
	                int n = graph[v].get(i);
	                if(!visited[n]){
	                    visited[n] = true;
	                    dist[n] = dist[v] + 1;
	                    queue.add(n);
	                    
	                    Max = Math.max(Max,dist[n]);
	                }
	            }
	        }
	    }
	}
	public static void main(String[] args) {
		TheFarthestNode sol = new TheFarthestNode();
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, 
		                {1, 3}, {1, 2}, {2, 4}, {5, 2}
		                };
		sol.solution(n, edge);
	}

}
