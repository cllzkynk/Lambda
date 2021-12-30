package lambda_dnme;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FuncitonalPrgrammin02 {

    	/*
	 		Method References : Class Name :: Method Name without method parenthesis
	 		Example ==>         String     :: length
	 							ArrayList  :: size
	 */

    public static void main(String[] args) {

        List<Integer> l = new ArrayList<Integer>();
        l.add(12);
        l.add(9);
        l.add(13);
        l.add(4);
        l.add(9);
        l.add(2);
        l.add(4);
        l.add(12);
        l.add(15);

        printElFunctional(l);
        System.out.println();
        PrintEvensFunctional(l);
        System.out.println();
        printSquaresOfOdd (l);
        System.out.println();
        printCubeOfDistinctOdds (l);
        System.out.println();
        sumOfSquareDistinctEvens (l);
        System.out.println();
        productOfCubeSutinctEvens (l);
        System.out.println();
        getMaxElement (l);
        System.out.println();
        getMinElements (l);
        System.out.println();
        getMinGreaterThanSevenEven(l);
        System.out.println();
        getHalfOfDistinctElReversed (l);

        System.out.println("deneme");

    }
    //1)Create a method to print the list elements on the console in the same line with a space between two consecutive
    // elements.(Method Reference)
    // If Java has any method we prefer to use it, if Java does not have it we create the method inside Utils class and use it


    public static void printElFunctional(List<Integer> l) {
                l.
                stream().
                forEach(Utils::printInTheSameLineWithASpace); //12 9 13 4 9 2 4 12 15
    }

    //2)Create a method to print the even list elements on the console in the same line with a space between two consecutive
    // elements.(Functional)

    public static void PrintEvensFunctional(List<Integer> l) {
                 l.
                stream().
                filter(Utils ::checkToBeEven).
                forEach(Utils::printInTheSameLineWithASpace); //12 4 2 4 12
    }

    //3)Create a method to print the square of odd list elements on the console in the same line with a space
    // between two consecutive elements.

    public static void printSquaresOfOdd (List<Integer> l) {

                 l.
                stream().
                filter(Utils ::checkToBeOdd).
                map(Utils::getSqure).
                forEach(Utils::printInTheSameLineWithASpace); //81 169 81 225

    }
    //4)Create a method to print the cube of distinct odd list elements on the console in the same line with a
    //space between two consecutive elements.

    public static void printCubeOfDistinctOdds (List<Integer> l) {
                  l.
                stream().
                distinct().
                filter(Utils::checkToBeOdd).
                map(Utils::getCube).
                forEach(Utils::printInTheSameLineWithASpace); //729 2197 3375
    }

    //5)Create a method to calculate the sum of the squares of distinct even elements

    public static void sumOfSquareDistinctEvens (List<Integer> l) {

        Integer sum = l.
                        stream().
                        distinct().
                        filter(Utils::checkToBeEven).
                        map(Utils::getSqure).
                        reduce(0, Math::addExact);

        System.out.println("The sum of the sqaures of even distinct elements is " + sum);
        //The sum of the sqaures of even distinct elements is 164
    }

    //6)Create a method to calculate the product of the cubes of distinct even elements
    public static void productOfCubeSutinctEvens (List<Integer> l) {

        Integer prod = l.
                        stream().
                        distinct().
                        filter(Utils::checkToBeEven).
                        map(Utils::getCube).
                        reduce(1, Math::multiplyExact);

        System.out.println("The multiplication of the cubes of even distinct elements is " + prod);
        //The multiplication of the cubes of even distinct elements is 884736
    }

    //7)Create a method to find the maximum value from the list elements
    public static void getMaxElement (List<Integer> l) {

        Integer maxEL = l.
                        stream().
                        reduce(Integer.MIN_VALUE, Math :: max);

        System.out.println("The max element is  " + maxEL);
        //The max element is  15
    }

    // 9) Create a method to find the minimum value from the list elements

    public static void getMinElements (List<Integer> l) {

        Integer minEL = l.
                        stream().
                        reduce(Integer.MAX_VALUE, Math ::min);
        System.out.println("The min element is  " + minEL);
        //The min element is  2
    }

    //10)Create a method to find the minimum value which is greater than 7 and even from the list

    public static void getMinGreaterThanSevenEven(List<Integer> l) {

        Integer minEl=l.
                        stream().
                        distinct().
                        filter(t->t>7).
                        filter(Utils::checkToBeEven).
                        reduce(Integer.MAX_VALUE, Math::min);

        System.out.println("1)The min element is  " + minEl);
        //1)The min element is  12
    }

    //11)Create a method to find the half of the elements which are distinct and greater than 5 in reverse in the list.
    public static void getHalfOfDistinctElReversed (List<Integer> l) {

        List<Double> resultList =	l.
                                    stream().distinct().
                                    filter(t->t>5).
                                    map(Utils::getHalf).
                                    sorted(Comparator.reverseOrder()).
                                    collect(Collectors.toList());

        System.out.println("Half of the elements list :  " + resultList);
        //Half of the elements list :  [7.5, 6.5, 6.0, 4.5]
    }




}


