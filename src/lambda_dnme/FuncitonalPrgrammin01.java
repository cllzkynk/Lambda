package lambda_dnme;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FuncitonalPrgrammin01 {
    /*
     * 1)Lambda is Functional Programming
     * 2) Functional Programming was add to Java
     * in Java 8, before Java 8 we were using just Structured Programming but after
     * Java 8 we are able to use both Functional Programming and Structured
     * Programming
     * 3) Structured Programming focuses on " How to do " most of the
     * times, Functional Programming focuses on "What to do "
     * 4) Functional
     * Programming is used with Collections, and Arrays
     */

    public static void main(String[] args) {

        List<Integer> l = new ArrayList<Integer>();
        l.add(12);
        l.add(9);
        l.add(131);
        l.add(14);
        l.add(9);
        l.add(10);
        l.add(4);
        l.add(12);
        l.add(15);
        printElStructured(l);
        System.out.println();
        printElFunctional (l);
        System.out.println();
        PrintEvensStructured (l);
        System.out.println();
        PrintEvensFunctional (l);
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
        getMaxElement2 (l);
        System.out.println();
        getMinElements2 (l);
        System.out.println();
        getMinGreaterThanSevenEven(l);
        System.out.println();
        getMinGreaterThanSevenEven2(l);
        System.out.println();
        getHalfOfDistinctElReversed (l);

    }

//1)Create a method to print the list elements on the console in the same line with a space between
//two consecutive elements.(Structured)

    public static void printElStructured (List<Integer> l) {

        for (Integer w : l) {
            System.out.print(w + " ");

        }
    }


    //1)Create a method to print the list elements on the console in the same line with a space between
    //two consecutive elements.(Functional)

    public static void printElFunctional (List<Integer> l) {
        l.stream().forEach(t->System.out.print(t + " "));


    }





//2)Create a method to print the even list elements on the console in the same line with a space between
    //two consecutive elements.(Structured)

    public static void PrintEvensStructured (List<Integer> l) {

        for (Integer w : l) {
            if(w%2==0) {
                System.out.print(w + " "); //12 4 2 4 12
            }

        }
    }


//3)Create a method to print the even list elements on the console in the same line with a space between
    //two consecutive elements.(Functional)

    public static void PrintEvensFunctional (List<Integer> l) {

        l.stream().filter(t->t%2==0).forEach(t->System.out.print(t + " ")); //12 4 2 4 12
        // t->t%2==0 then name of that structure is called "Lambda Expression"
    }




//4)Create a method to print the square of odd list elements on the console in the same line with a space
//between two consecutive elements.

    public static void printSquaresOfOdd (List<Integer> l) {

        l.stream().filter(t->t%2!=0).map(t->t*t).forEach(t->System.out.print(t + " "));

        //map () is used to change the value of elements

    }


//5)Create a method to print the cube of distinct odd list elements on the console in the same line with a
//space between two consecutive elements.

    public static void printCubeOfDistinctOdds (List<Integer> l) {
        l.stream().distinct().filter(t->t%2!=0).map(t->t*t*t).forEach(t->System.out.print(t + " "));
        //distinct() removes repeated ones

    }



//6)Create a method to calculate the sum of the squares of distinct even elements

    public static void sumOfSquareDistinctEvens (List<Integer> l) {

        Integer sum = l.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce(0, (t,u)->t+u);
        // For sum make the first parameter zero

        System.out.println("The sum of the sqaures of even distinct elements is " + sum);

    }



    //7)Create a method to calculate the product of the cubes of distinct even elements
    public static void productOfCubeSutinctEvens (List<Integer> l) {

        Integer prod = l.stream().distinct().filter(t->t%2==0).map(t->t*t*t).reduce(1, (t,u)->t*u);

        System.out.println("The multiplication of the cubes of even distinct elements is " + prod);

    }


    //8)Create a method to find the maximum value from the list elements
    //1.Way
    public static void getMaxElement (List<Integer> l) {

        Integer maxEL = l.stream().reduce(Integer.MIN_VALUE, (t,u)-> t>u ? t : u);

        System.out.println("The max element is  " + maxEL);

    }

    //2.Way
    public static void getMaxElement2 (List<Integer> l) {
        //sorted () ==> Returns a stream consisting of the elements of this stream. sorted according to natural order.

        Integer maxEL =	l.stream().distinct().sorted().reduce(Integer.MIN_VALUE, (t,u) -> u);

        System.out.println("The max element is  " + maxEL);
    }


// 9) Create a method to find the minimum value from the list elements

    //1.Way
    public static void getMinElements (List<Integer> l) {

        Integer minEL = l.stream().reduce(Integer.MAX_VALUE, (t,u)-> t<u ? t : u);
        System.out.println("The min element is  " + minEL);
    }

    //2.Way
    public static void getMinElements2 (List<Integer> l) {
        //sorted () ==> Returns a stream consisting of the elements of this stream. sorted according to natural order.

        Integer minEL =	l.stream().distinct().sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE, (t, u) -> u);

        System.out.println("The min element is  " + minEL);

    }


//10)Create a method to find the minimum value which is greater than 7 and even from the list

    //1 Way
    public static void getMinGreaterThanSevenEven(List<Integer> l) {

        Integer minEl=l.stream().distinct().filter(t->t>7 && t%2==0).reduce(Integer.MAX_VALUE, (t,u)->t<u ? t : u);

        System.out.println("1)The min element is  " + minEl);

    }

    //2.Way
    public static void getMinGreaterThanSevenEven2(List<Integer> l) {

        //Use findFirst() together with get() to get Integer return type
        Integer minEl =	l.stream().distinct().filter(t->t>7 && t%2==0).sorted().findFirst().get();


        System.out.println("2)The min element is  " + minEl);

    }

    //10)Create a method to find the half of the elements which are distinct and greater than 5 in reverse in the list.
    public static void getHalfOfDistinctElReversed (List<Integer> l) {

        List<Double> resultList =	l.stream().distinct().filter(t->t>5).map(t->t/2.0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println("Half of the elements list :  " + resultList);  //[65, 7, 7, 6, 5, 4]
    }



}




