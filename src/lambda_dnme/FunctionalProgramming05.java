package lambda_dnme;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgramming05 {

    public static void main(String[] args) {

        Course courseTurkishDay = new Course("Summer", "Turkish Day", 97, 128);
        Course courseTurkishNight = new Course("Winter", "Turkish Night", 98, 154);
        Course courseEnglishDay = new Course("Spring", "English Day", 95, 132);
        Course courseEnglishNight = new Course("Winter", "English Night", 93, 144);

        List<Course> coursesList = new ArrayList<>();
        coursesList.add(courseTurkishDay);
        coursesList.add(courseTurkishNight);
        coursesList.add(courseEnglishDay);
        coursesList.add(courseEnglishNight);

        System.out.println(CheckAvgScoreToBeGreaterThan91 (coursesList, 91 )); //true
        System.out.println(checkAnyCourseNameContainsTurkish(coursesList)); //true
        courseHasHighestAvg (coursesList);
        System.out.println();
        System.out.println(sortAvgAscSkipFirstTwo (coursesList));
        System.out.println(sortAvgAscGetthird (coursesList));

    }
    //1)Create a method to check if all average scores are greater than 91
    public static boolean CheckAvgScoreToBeGreaterThan91 (List<Course> coursesList, double avg ){

        return coursesList.stream().allMatch(t->t.getAverageScore()>avg);
    }
    //2)Create a method to check if at least one of the course names contains â€œTurkishâ€? word
    public static boolean checkAnyCourseNameContainsTurkish(List<Course> coursesList){

        return coursesList.stream().anyMatch(t->t.getCourseName().contains("Turkish"));
    }
    //3)Create a method to print the course whose average score is the highest
    public static void courseHasHighestAvg (List<Course> coursesList){
       Course result =  coursesList.stream().sorted(Comparator.comparing(Course::getAverageScore).reversed()).findFirst().get();
        System.out.println(result);
    }
    //4)Sort the list elements according to the average score in ascending order and skip first 2 elements
    public static List<Course> sortAvgAscSkipFirstTwo (List<Course> coursesList){
       return coursesList.stream().sorted(Comparator.comparing(Course::getAverageScore)).skip(2).collect(Collectors.toList());
    }
    //5)Sort the list elements according to the average score in ascending order and print just 3rd one
    public static List<Course> sortAvgAscGetthird (List<Course> coursesList){
        return coursesList.stream().sorted(Comparator.comparing(Course::getAverageScore)).skip(2).limit(1).collect(Collectors.toList());
    }
}
