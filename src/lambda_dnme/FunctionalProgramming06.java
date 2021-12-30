package lambda_dnme;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FunctionalProgramming06 {

    public static void main(String[] args) throws IOException {

        //How to read text from the file
        // Files.lines(Paths.get("/Users/orcunfazli/IdeaProjects/lambdacourse/src/lambdacourse/LambdaTestFile.txt")).forEach(System.out::println);


        System.out.println("================");

        //How to convert all characters in the file to upper case
//        Files.lines(Paths.
//                        get("/Users/orcunfazli/IdeaProjects/lambdacourse/src/lambdacourse/LambdaTestFile.txt")).
//                map(String::toUpperCase).
//                forEach(System.out::println);

        System.out.println("================");

        //How to check if a specific word(Lambda) exists in the text

//        boolean result = Files.lines(Paths.
//                        get("/Users/orcunfazli/IdeaProjects/lambdacourse/src/lambdacourse/LambdaTestFile.txt")).
//                anyMatch(t -> t.contains("Lambda"));
//        System.out.println(result);

        System.out.println("================");

        //Print distinct words on the console in the file
//        Files.lines(Paths.
//                get("/Users/orcunfazli/IdeaProjects/lambdacourse/src/lambdacourse/LambdaTestFile.txt")).
//                map(t -> t.split(" ")).
//                flatMap(Arrays::stream).
//                distinct().
//                forEach(System.out::println);

        System.out.println("================");

        //Get the words which end with â€œeâ€? and print them on the console
        Files.lines(Paths.
                 get("/Users/orcunfazli/IdeaProjects/lambdacourse/src/lambdacourse/LambdaTestFile.txt")).
                map(t->t.split(" ")).
                flatMap(Arrays::stream).
                filter(t->t.endsWith("e")).
                forEach(System.out::println);
    }
}