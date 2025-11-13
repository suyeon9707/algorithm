/* 프로그래머스 붕대감기 */
public class ToBandage{
    public int solution(int[] bandage, int health, int[][] attacks) {
        int count = 1;
        int finalhealth = health;
        int iSize = attacaks.length;
        int forSize = attacks[iSize -1][0];
        //공격시간 초만큼 돌기
        for(int i=1; i <= forSize; i++) {
            int isAttack = 0;
            for(int m = 0; m < attacks.length; m++) {
                if(attacks[m][0] == i) {
                    isAttack = 1;
                    finalhealth = finalhealth - attacks[m][1];
                    count = 0;
                    if(finalhealth <= 0)
                        return -1;
                }
            }
            if(isAttack == 0) {
                if(finalhealth == health) {
                    count ++;
                    continue;
                }
                else {
                    finalhealth += bandage[1];
                    count++;
                    if(count == bandage[0]) {
                        finalhealth += bandage[2];
                        count = 0;
                    }

                    if(finalhealth > health)
                        finalhealth = health;
                }
            }
        }
        return finalhealth;
    }
}