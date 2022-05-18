import java.util.PriorityQueue;

public class Programmers_셔틀버스 {
	static class ShuttleBus {
	    static class Time implements Comparable<Time> { 
	    	
	    	int hour;
	    	int minute;
	    	
	    	public Time(int h, int m) {
	    		if(m<0) {
	    			m += 60;
	    			h--;
	    		}
	    		if(m>=60) {
	    			m-=60;
	    			h++;
	    		}
	    		this.hour = h;
	    		this.minute = m;
	    	}
	    	public int compareTo(Time o) {
	    		if(hour == o.hour) {
	    			return minute - o.minute;
	    		}
	    		return hour - o.hour;
	    	}
	    }
	    static PriorityQueue<Time> pq = new PriorityQueue<>();
	    static String answer;
		public String solution(int n, int t, int m, String[] timetable) {
	        
	        for (int i = 0; i < timetable.length; i++) {
				String[] time = timetable[i].split(":");
				pq.add(new Time(Integer.parseInt(time[0]), Integer.parseInt(time[1])));
			}
	        bus(n,t,m);
	        return answer;
	    }
	    static void bus(int n, int t, int m) {
	    	Time bus = new Time(9,0);
	    	Time corn = new Time(9,0);
	    	String hour="";
	    	String minute="";
	    	for (int i = 0; i < n; i++) {
	    		int people = 0;
				for (int j = 0; j < m; j++) {
					if(!pq.isEmpty()) {
						Time temp = pq.peek();
						
						if(bus.compareTo(temp) >= 0) {
							corn = pq.poll();
							people++;
						}
					}
					if(i == n-1 && people == m) {
						corn = new Time(corn.hour, corn.minute - 1);
					}
					else if(i == n - 1 && people<m) {
						corn = new Time(bus.hour, bus.minute);
					}
				}
				bus = new Time(bus.hour, bus.minute + t);
			}
	    	
	    	answer += (corn.hour < 10 ? "0"+corn.hour : corn.hour)+":"+ (corn.minute<10?"0"+corn.minute : corn.minute);
	    }
	}
	public static void main(String[] args) {
		ShuttleBus sol = new ShuttleBus();
		int n=1;
		int t=1;
		int m=5;
		String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
		sol.solution(n, t, m, timetable);
	}
}
