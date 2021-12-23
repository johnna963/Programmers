import java.util.LinkedList;
import java.util.Queue;

public class Programmers_카카오프렌즈컬러링북{
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}	
	}
	static int cnt;
	static class KakaoFriendsColoringBook {
	    public int[] solution(int m, int n, int[][] picture) {
	    	int numberOfArea = 0;
	        int maxSizeOfOneArea = 0;
	        boolean[][] check = new boolean[m][n];
	        int[] answer = new int[2];
	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                if(picture[i][j] != 0 && !check[i][j]){
	                    BFS(i,j, check, picture);
	                    numberOfArea++;
	                    maxSizeOfOneArea = Math.max(cnt, maxSizeOfOneArea);
	                    cnt = 0;
	                }        
	            }
	        }
	        answer[0] = numberOfArea;
	        answer[1] = maxSizeOfOneArea;
	        return answer;
	    }
	}
	static void BFS(int x, int y, boolean[][] check, int[][] picture){ 
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(x,y));
        check[x][y] = true;
        int m = picture.length;
        int n = picture[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0 ,1};
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            cnt++;
            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                    if(picture[nx][ny] == picture[node.x][node.y] && !check[nx][ny]){
                        check[nx][ny] = true;
                        queue.add(new Node(nx,ny));
                    }
                }
            }
        }
        
    }
	public static void main(String[] args) {
		KakaoFriendsColoringBook sol = new KakaoFriendsColoringBook();
		int m = 6;
		int n = 4;
		int[][] picture= {
				{1, 1, 1, 0}, {1, 2, 2, 0}, 
				{1, 0, 0, 1}, {0, 0, 0, 1}, 
				{0, 0, 0, 3}, {0, 0, 0, 3}
		};
		sol.solution(m, n, picture);
	}
}
