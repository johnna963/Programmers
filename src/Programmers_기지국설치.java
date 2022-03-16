
public class Programmers_기지국설치 {
	static class BaseStationInstallation {
	    public int solution(int n, int[] stations, int w) {
	        int answer = 0;
	        int location = 1;
	        int cnt = 0;
	        
	        while(location <= n) {
	        	if(cnt < stations.length && location >= stations[cnt] - w) {
	        		location = stations[cnt] + w + 1;
	        		cnt++;
	        				
	        	}
	        	else {
	        		answer +=1;
	        		location +=(w*2)+1;
	        	}
	        }

	        return answer;
	    }
	}
	public static void main(String[] args) {
		BaseStationInstallation sol = new BaseStationInstallation();
		int n = 11 ;
		int[] stations = {4,11};
		int w = 1;
		sol.solution(n, stations, w);
	}

}
