
class GreedyGymsuit {
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int count = n - lost.length;
        for(int i = 0; i < lost.length; i++) {
            for(int j=0; j < reserve.length; j++){
                //losßt[i] ->2 +1 =3
                if(lost[i]-1 != reserve[j] && lost[i]+1 ==reserve[j]){
                    count++;
                    reserve[j] = 0;
                    break;
                }
                //lost[i] -> 4 -1 =3
                else if(lost[i]-1 == reserve[j]) {
                    count++;
                    System.out.println("2");
                    break;
                }
                else if(lost[i]==reserve[j])
                    continue;
            }
        }
        return count;
    }
//    public static void main(String args[]){
//        int c = 4;
//        int a[] = {2};
//        int b[] = {2};
//        int d=0;
//        d = solution(c,a,b);
//        System.out.println(d);
//    }
}
