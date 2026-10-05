class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            String filtered = skillTree.replaceAll("[^" + skill + "]", "");

            if (skill.indexOf(filtered) == 0) {
                answer++;
            }
        }

        return answer;
    }
}