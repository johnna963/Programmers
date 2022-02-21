import java.util.*;
public class Programmers_게임맵최단거리 {
	static class TheShortestGameMap {
	    public int solution(int[][] maps) {
	    	int answer = 0;
	        int n = maps.length;
	        int m = maps[0].length;
	        answer = bfs(maps,n,m);
	        return answer;
	    }
	    static class Node{
	        int x;
	        int y;
	        int dist;
	        public Node(int x, int y, int dist){
	            this.x = x;
	            this.y = y;
	            this.dist = dist;
	        }
	    }
	    static int bfs(int[][] maps, int n, int m){
	        boolean[][] visit = new boolean[n][m];
	        int[] dx = {-1,0,1,0};
	        int[] dy = {0,-1,0,1};
	        
	        Queue<Node> queue = new LinkedList<>();
	        queue.add(new Node(0,0,1));
	        visit[0][0] = true;
	        while(!queue.isEmpty()){
	            Node node = queue.poll();
	            int x = node.x;
	            int y = node.y;
	            int d = node.dist;
	            if(x == n-1 && y == m-1){
	                return d;
	            }
	            for(int k = 0; k < 4; k++){
	                int nx = x+dx[k];
	                int ny = y+dy[k];
	                if(nx >= 0 && ny >= 0  && nx < n && ny < m){
	                    if(maps[nx][ny] == 1 && !visit[nx][ny]){
	                        visit[nx][ny] = true;
	                        queue.add(new Node(nx, ny, d+1));
	                    }
	                }
	            }
	        }
	        return -1;
	    }
	}
	public static void main(String[] args) {
		TheShortestGameMap sol = new TheShortestGameMap();
		int[][] maps= {
				{1,0,1,1,1},
				{1,0,1,0,1},
				{1,0,1,1,1},
				{1,1,1,0,1},
				{0,0,0,0,1}
				};
		sol.solution(maps);
	}
}
