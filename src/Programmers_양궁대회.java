import java.util.ArrayList;
import java.util.Collections;

public class Programmers_양궁대회 {
	static class ArcheryTournament {
		static ArrayList<int[]> answer = new ArrayList<>();
	    static int[] Ryan;
	    static int[] Apeach;
	    static int N;
	    static int max = Integer.MIN_VALUE;
	    public int[] solution(int n, int[] info) {
	        Ryan = new int[11];
	        N=n;
	        Apeach = info.clone();
	        DFS(0, 0);
	        if(answer.isEmpty()) {
	        	return new int[] {-1};
	        }
	        Collections.sort(answer, (o1, o2) -> {
	            for (int i = 10; i >= 0; i--) {
	                if (o1[i] != o2[i]) return o2[i] - o1[i];
	            }
	            return 0;
	        });
	        return answer.get(0);
	    }
	    public static void DFS(int L, int s) {
	        if (L == N) {
	            int a = 0;
	            int r = 0;
	            for (int i = 0; i <= 10; i++) {
	                if (Apeach[i] == 0 && Ryan[i] == 0) continue;
	                if (Apeach[i] < Ryan[i]) r += 10-i;
	                else a += 10-i;
	            }
	            if (r > a) {
	                int diff = r-a;
	                if (diff > max) {
	                    max = diff;
	                    answer.clear();
	                    answer.add(Ryan.clone());
	                }
	                else if (diff == max) answer.add(Ryan.clone());
	            }
	        }
	        else {
	            for (int i = s; i < 11; i++) {
	                Ryan[i]++;
	                DFS(L+1, i);
	                Ryan[i]--;
	            }
	        }
	    }
	   
	}
	public static void main(String[] args) {
		ArcheryTournament sol = new  ArcheryTournament();
		int n = 5;
		int[] info = {2,1,1,1,0,0,0,0,0,0,0};
		System.out.println(sol.solution(n, info));
	}
}
