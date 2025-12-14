import java.util.*;

class MemoryScore {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> nameScoreMap = new HashMap<>();
        for(int i=0; i <name.length; i++) {
            nameScoreMap.put(name[i], yearning[i]);
        }

        for(int i=0; i<photo.length; i++) {
            Integer score = 0;
            for(int j=0; j<photo[i].length; j++) {
                String name2 = photo[i][j];
                if(nameScoreMap.get(name2) != null)
                    score += nameScoreMap.get(name2);
            }
            answer[i] = score;
        }
        return answer;
    }
}