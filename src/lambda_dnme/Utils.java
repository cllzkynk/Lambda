package lambda_dnme;

import java.util.List;

public class Utils {

    public static void printInTheSameLineWithASpace (Object o) {
            System.out.print(o + " ");
        }


    public static boolean checkToBeEven (int x ) {

        return x%2 ==0;
    }

    public static boolean checkToBeOdd (int x) {
        return x%2!=0;
    }

    public static Integer getSqure(int x) {

        return x*x;
    }

    public static Integer getCube (int x) {
        return x*x*x;
    }
    public static Double getHalf (int x) {
        return x/2.0;
    }
    public static Integer getSumOfDigits (int x){
        int sum = 0;

        while (x!=0){
            sum = sum + x%10;
            x = x/10;
        }
        return sum;
    }

}


