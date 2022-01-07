
public class Programmers_피로도 {
	static class Fatigue {
	    static int max = 0;
	    public int solution(int k, int[][] dungeons) {
	        int answer = -1;
	        boolean[] check = new boolean[dungeons.length];
	        dfs(k,dungeons,check,0);
	        answer = max;
	        return answer;
	    }
	    void dfs(int k,int[][] dungeons,boolean[] check,int cnt){
	        for(int i = 0; i < dungeons.length; i++){
	            if(check[i]){
	                continue;
	            }
	            if(k<dungeons[i][0]){
	                continue;
	            }
	            check[i] = true;
	            dfs(k - dungeons[i][1],dungeons,check,cnt + 1);
	            check[i] = false;
	        }
	        max = Math.max(cnt,max);
	    }
	}
	public static void main(String[] args) {
		Fatigue sol = new Fatigue();
		
		int k = 80;
		int[][] dungeons = {
				{80,20},{50,40},{30,10}	
		};
		sol.solution(k, dungeons);
	}

}
