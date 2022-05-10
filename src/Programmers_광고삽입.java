
public class Programmers_광고삽입 {
	static class AdInsertion {
	    public String solution(String play_time, String adv_time, String[] logs) {
	        int playTime = timeToSecond(play_time);
	        int advTime = timeToSecond(adv_time);
	        int[] total = new int[playTime + 1];
	        
	        for (String log : logs) {
				String[] arr = log.split("-");
				
				int start = timeToSecond(arr[0]);
				int end = timeToSecond(arr[1]);
				for (int i = start; i < end; i++) {
					total[i]++;
				}
			}
	        
	        long sum = 0;
	        for (int i = 0; i < advTime; i++) {
				sum += total[i];
			}
	        
	        long max = sum;
	        int start = 0;
	        
	        for (int i = 1, j = advTime; j < playTime; i++, j++) {
				sum += total[j] - total[i-1];
				
				if(max < sum) {
					max = sum;
					start = i;
				}
			}
	        return secondToTime(start);
	    }

		static int timeToSecond(String time) {
			int second = 0;
			String[] arr = time.split(":");
			
			second += Integer.parseInt(arr[0]) * 3600;
			second += Integer.parseInt(arr[1]) * 60;
			second += Integer.parseInt(arr[2]);
			
			return second;
		}
		static String secondToTime(int second) {
			StringBuilder sb = new StringBuilder();
			for (int i = 2; i >= 0; i--) {
				int t = second/(int)Math.pow(60, i);
				second %= (int)Math.pow(60, i);
				
				if(t<10) {
					sb.append(0).append(t);
					
				}else {
					sb.append(t);
				}
				
				if(i != 0) {
					sb.append(":");
				}
			}
			return sb.toString();
		}
	}
	public static void main(String[] args) {
		AdInsertion sol = new AdInsertion();
		String play_time = "02:03:55";
		String adv_time= "00:14:15";
		String[] logs = {
				"01:20:15-01:45:14", "00:40:31-01:00:00", 
				 "00:25:50-00:48:29", "01:30:59-01:53:29",
				 "01:37:44-02:02:30"
		};
		System.out.println(sol.solution(play_time, adv_time, logs));
	}

}
