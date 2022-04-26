
public class Programmers_스킬트리 {
	static class SkillTree {
	    public int solution(String skill, String[] skill_trees) {
	        int answer = 0;
	        for (String s : skill_trees) {
	        	String skilltree = s;
				for (int i = 0; i < s.length(); i++) {
					String t = String.valueOf(s.charAt(i));
					if(!skill.contains(t)) {
						skilltree = skilltree.replace(t, "");
					}
				}
				if(skill.indexOf(skilltree) == 0) {
					answer +=1;
				}
			}
	        return answer;
	    }
	}
	public static void main(String[] args) {
		SkillTree sol = new SkillTree();
		String skill = "CBD";
		String[] skill_trees= {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(sol.solution(skill, skill_trees));
	}
}
