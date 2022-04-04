
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckTheDistance {
	/**
	 * 대기실은 5개이며, 각 대기실은 5*5
	 * 거리두기를 위하여 맨해튼거리가 2이하로 가면안됨 
	 * 파티션으로 막혀 있으면 허용
	 * 거리두기를 지키고 있으면 1 지키지않으면 0
	 * P는 앉은 자리 O는 빈테이블 X는 파티션*/
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static String[][] map ;//대기실 지도
	static boolean[][] visited;//방문
	//클래스 저장
	static class Pos {
		int x;
		int y;
		int cnt;
		public Pos(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}

	static class checkthedistance {	
	    public int[] solution(String[][] places) {
	        int[] answer = new int[places.length];
	        map  = new String[places.length][5];
	        visited  = new boolean[places.length][5];
	        for (int i = 0; i < places.length; i++) {
				for (int j = 0; j < 5; j++) {
					String[] line = places[i][j].split("");
					for (int k = 0; k < 5; k++) {
						map[j][k] = line[k];
					}
					Arrays.fill(visited[j], false);
				}
				int res = 1;
				for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						if(map[j][k].equals("P")) {
							res = Math.min(res, bfs(j,k));
						}
					}
				}
				if(res == 0) {
					answer[i] = 0;
				}
				else {
					answer[i] = 1;
				}
			}
	        System.out.println(Arrays.toString(answer));
	        return answer;
	    }
	}
	static int bfs(int x, int y){
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.add(new Pos(x,y,0));
		boolean check = true;//판단
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			if(pos.cnt>=2) {
				continue;
			}
			for (int i = 0; i < dx.length; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				int dis = pos.cnt;
				
				if(nx>=0&&ny>=0&&nx<5&&ny<5) {
					if(!visited[nx][ny]) {
						if(map[nx][ny].equals("O")) {
							queue.add(new Pos(nx,ny,dis +1));
						}
						else if (map[nx][ny].equals("P")) {
							if(pos.cnt<=2) {
								check = false;
								break;
							}
						}
					}
				}
			}
			if(!check) {
				return 0;
			}
		}
		for (int i = 0; i < visited.length; i++) {
			Arrays.fill(visited[i], false);
		}
		return 1;
	}
	
	
	public static void main(String[] args) {
		String[][] str = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
						{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
						{"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, 
						{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
						{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		//System.out.println(str[0][0].charAt(1));
		checkthedistance sol = new checkthedistance();
		sol.solution(str);
	}
}
