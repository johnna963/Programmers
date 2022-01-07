import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Programmers_배달 {
	static class Delivery {
		static class Node implements Comparable<Node>{
	        int n;
	        int dist;
	        public Node(int n, int dist){
	            this.n = n;
	            this.dist = dist;
	        }
	        public int compareTo(Node o){
	            return this.dist - o.dist;
	        }
	    }
		static ArrayList<Node>[] list;
	    static int[] distance;
	    public int solution(int N, int[][] road, int K) {
	        int answer = 0;
	        list = new ArrayList[N+1];
	        distance = new int[N+1];
	        Arrays.fill(distance, Integer.MAX_VALUE);
	        for(int i = 1; i <= N; i++){
	            list[i] = new ArrayList<>();
	        }
	        for(int i = 0; i < road.length; i++){
	            int from = road[i][0];
	            int to = road[i][1];
	            int dist = road[i][2];
	            list[from].add(new Node(to,dist));
	            list[to].add(new Node(from,dist));
	        }
	        distance[1] = 0;
	        dijkstra();
	        for(int i = 0; i <= N; i++){
	            if(distance[i]<=K){
	                answer++;
	            }
	        }
	        return answer;
	    }
	    static void dijkstra(){
	        PriorityQueue<Node> q = new PriorityQueue<>();
	        q.add(new Node(1,0));
	        while(q.isEmpty()){
	            Node node = q.poll();
	            int to = node.n;
	            int dist = node.dist;
	            if(distance[to] < dist){
	                continue;
	            }
	            for(int i = 0; i < list[to].size();i++){
	                int to2 = list[to].get(i).n;
	                int dist2 = list[to].get(i).dist + dist;
	                if(distance[to2] > dist2){
	                    distance[to2] = dist2;
	                    q.add((new Node(to2,dist2)));
	                }
	            }
	        }
	    }
	}
	public static void main(String[] args) {
		Delivery sol = new Delivery();
		int N = 5;
		int[][] road = {
				{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}
		};
		int K = 3;
		sol.solution(N, road, K);
	}

}
