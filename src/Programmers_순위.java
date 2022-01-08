import java.util.*;
public class Programmers_순위 {
	static class Ranking { 
	    public int solution(int n, int[][] results) {
	        int answer = 0;
	        int INF = 10001;
	        int[][] graph = new int[n+1][n+1];
	        for(int i = 0; i < n+1; i++){
	            for(int j = 0; j <n+1;j++) {
	            	graph[i][j] = INF;
	            }
	        }
	        for(int i = 0; i < results.length;i++){
	            graph[results[i][0]][results[i][1]] = 1;
	        }
	        for(int k = 1; k < n+1; k++){
	            for(int i = 1; i < n+1; i++){
	                for(int j = 1; j < n+1; j++){
	                    if(graph[i][j] > graph[i][k] + graph[k][j]){
	                        graph[i][j] = graph[i][k] + graph[k][j];
	                    }
	                }
	            }
	        }
	        for(int i = 1; i < n+1; i++){
	            boolean flag = true;
	            for(int j = 1; j < n+1; j++){
	                if(i==j)continue;
	                if(graph[i][j] == INF && graph[j][i] == INF){
	                    flag = false;
	                    break;
	                }
	            }
	            if(flag){
	                answer++;
	            }
	        }
	        for (int i = 1; i < n+1; i++) {
				for (int j = 1; j < n+1; j++) {
					System.out.print(graph[i][j] + " ");
				}
				System.out.println();
			}
	        System.out.println(answer);
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Ranking sol = new Ranking();
		int n = 5;
		int[][] results = {
				{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}
		};
		sol.solution(n, results);
	}

}
