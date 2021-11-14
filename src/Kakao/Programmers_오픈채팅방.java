package Kakao;

import java.util.ArrayList;
import java.util.HashMap;

public class Programmers_오픈채팅방 {
	
	static class OpenChatRoom {
		
	    public String[] solution(String[] record) {
	    	ArrayList<String> log = new ArrayList<>();
			HashMap<String, String> hm = new HashMap<>();
			
			for (int i = 0; i < record.length; i++) {
				String[] str = record[i].split(" ");
				if("Enter".equals(str[0])) {
					log.add(str[1] + "님이 들어왔습니다.");
					hm.put(str[1], str[2]);
				}
				else if("Change".equals(str[0])) {
					hm.put(str[1], str[2]);
				}
				else {
					log.add(str[1] + "님이 나갔습니다.");
				}
			}
	        String[] answer = new String[log.size()];
	        
	        for (int i = 0; i < log.size(); i++) {
				int index = log.get(i).indexOf("님");
				
				String str = log.get(i).substring(0,index);
				
				answer[i] = hm.get(str) + log.get(i).substring(index);
				//System.out.println(answer[i]);
			}
	        
	        
	        return answer;
	    }
	}
	

	public static void main(String[] args) {
		OpenChatRoom sol = new OpenChatRoom();
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		sol.solution(record);
	}

}
