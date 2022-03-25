

public class Programmers_프렌즈4블록 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static class Friends4Block {
	    public int solution(int m, int n, String[] board) {
	        int answer = 0;
	        char[][] map = new char[m][n];
	        for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = board[i].charAt(j);
				}
			}
	        while(true) {
	        	int cnt = CheckBlock(m, n, map);
	        	if(cnt == 0 ) {
	        		break;
	        	}
	        	answer += cnt;
	        	dropBlock(m,n,map);
	        }
	        System.out.println(answer);
	        return answer;
	    }

		void dropBlock(int m, int n, char[][] map) {
			for (int i = 0; i < n; i++) {
				for (int j = m - 1; j >=0 ; j--) {
					if(map[j][i]=='0') {
						for (int k = j - 1; k >= 0; k--) {
							if(map[k][i] != '0') {
								map[j][i] = map[k][i];
								map[k][i] ='0';
								break;
							}
						}
					}
				}
			}
		}

		static int CheckBlock(int m, int n, char[][] map) {
			int cnt = 0;
			boolean[][] check = new boolean[m][n];
			for (int i = 0; i < m-1; i++) {
				for (int j = 0; j < n-1; j++) {
					if(map[i][j] == '0') continue;
					checkFourBlock(map, check,i,j);
				}
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if(check[i][j]) {
						cnt++;
						map[i][j] = '0';
					}
				}
			}
			return cnt;
		}

		static void checkFourBlock(char[][] map, boolean[][] check, int i, int j) {
			char block = map[i][j];
			for (int k = i; k < i + 2; k++) {
				for (int l = j; l < j + 2; l++) {
					if(map[k][l] != block) {
						return;
					}
				}
			}
			
			for (int k = i; k < i+2; k++) {
				for (int l = j; l < j+2; l++) {
					check[k][l] = true;
				}
			}
		}
	    
	}
	public static void main(String[] args) {
		Friends4Block sol = new Friends4Block();
		int m = 4;
		int n = 5;
		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		sol.solution(m, n, board);
	}

}
