import java.util.*;


public class Programmers_신고결과받기 {
	static class ReceivingReportResults {
	    public int[] solution(String[] id_list, String[] report, int k) {
	        int[] answer = new int[id_list.length];
	        Map<String, Integer> index = new HashMap<String, Integer>();
	        Map<String, List<Integer>> list = new HashMap<>();
	        
	        for (int i = 0; i < id_list.length; i++) {
				index.put(id_list[i], i);
			}
	        
	        for (String rep : report) {
				String[] idx = rep.split(" ");
				String fromId = idx[0];
				String toId = idx[1];
				if(!list.containsKey(toId)) {
					list.put(toId, new ArrayList<Integer>());
				}
				List<Integer> temp = list.get(toId);
				if(!temp.contains(index.get(fromId))) {
					temp.add(index.get(fromId));
				}
			}
	        
	        for (int i = 0; i < id_list.length; i++) {
				String id = id_list[i];
				if(list.containsKey(id) && list.get(id).size()>=k) {
					for (int idx : list.get(id)) {
						answer[idx]++;
					}
				}
			}
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		ReceivingReportResults sol = new ReceivingReportResults();
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		System.out.println(sol.solution(id_list, report, k));
	}

}
