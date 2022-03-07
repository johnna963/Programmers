import java.util.HashMap;

public class Programmers_다단계칫솔판매 {
	static class Person{
		String name;
		Person parent;
		int profit;
		public Person(String name) {
			this.name = name;
			this.parent = null;
			this.profit = 0;
		}
	}
	static class MultiLevelToothbrushSales {
	    public int[] solution(String[] enroll, String[] referral, 
	    		String[] seller, int[] amount) {
	        int[] answer = new int[enroll.length];
	        HashMap<String, Person> people = new HashMap<>();
	        people.put("-", new Person("-"));
	        for (int i = 0; i < enroll.length; i++) {
				people.put(enroll[i], new Person(enroll[i]));
			}
	        for (int i = 0; i < referral.length; i++) {
				people.get(enroll[i]).parent = people.get(referral[i]);
			}
	        for (int i = 0; i < seller.length; i++) {
				addProfit(people.get(seller[i]),amount[i] *100);
			}
	        for (int i = 0; i < enroll.length; i++) {
				answer[i] = people.get(enroll[i]).profit;
			}
	        for (int i = 0; i < answer.length; i++) {
				System.out.println(answer[i]);
			}
	        return answer;
	    }

		static void addProfit(Person person, int profit) {
			int profit_parent = profit / 10;
			if(profit_parent != 0 && person.parent !=null) {
				person.profit += profit - profit_parent;
				addProfit(person.parent, profit_parent);
			}else {
				person.profit += profit;
			}
		}
	}

	public static void main(String[] args) {
		MultiLevelToothbrushSales sol = new MultiLevelToothbrushSales();
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral= {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller= {"young", "john", "tod", "emily", "mary"};
		int[] amount= {12, 4, 2, 5, 10};
		sol.solution(enroll, referral, seller, amount);
	}

}
