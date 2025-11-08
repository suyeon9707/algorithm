import java.util.*;

class Dice {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        List<Integer> numList = new ArrayList<>();
        numList.add(a);
        numList.add(b);
        numList.add(c);
        numList.add(d);
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i=0 ; i<numList.size(); i++) {
            if(!countMap.containsKey(numList.get(i)))
                countMap.put(numList.get(i), 1);
            else {
                int count = countMap.get(numList.get(i));
                countMap.put(numList.get(i), count+1);
            }
        }
        if(countMap.size() == 4)
        {
            Set<Integer> keySet = countMap.keySet();
            answer = Collections.min(keySet);
        }
        if(countMap.size() == 3) {
            answer = 1;
            for(int i=1; i<=6; i++) {
                if(countMap.containsKey(i))
                    if(countMap.get(i) == 1)
                        answer *= i;
            }
        }
        int p = 0;
        int q = 0;
        int flag = 0;
        if(countMap.size() == 2) {
            for (int i = 1; i <= 6; i++) {
                if (countMap.containsKey(i)) {
                    if (countMap.get(i) == 3) {
                        flag =1;
                        p = i;
                    }
                    if(countMap.get(i) == 1)
                        q = i;
                }
            }
            answer = (10 * p +q ) * (10*p+q);
            for(int i=1; i<=6; i++) {
                if(countMap.containsKey(i)) {
                    if(countMap.get(i) == 2) {
                        if(p == 0)
                            p = i;
                        else
                            q = i;
                    }
                }
            }
            if(flag == 1) return answer;

            if(p > q)
                return answer = (p+q) * (p-q);
            else return answer = (p+q) * (q-p);
        }
        if(countMap.size() == 1)
            answer = 1111*a;
        return answer;
    }
}
