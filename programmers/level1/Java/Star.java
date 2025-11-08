
//직사각형 별찍기
import java.util.Scanner;

class Star {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for(int m=0; m < b; m++){
            for(int n=0; n<a; n++)
                System.out.print("*");
            System.out.print("\n");
        }
    }
}
