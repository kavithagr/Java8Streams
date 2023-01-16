package functionalProgramming;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingByConcurrent;
import static java.util.stream.Collectors.toList;

public class FS2FunctionalProgramming {
    public static void main(String[] args) {


        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        List<String> coursesArrayList = new ArrayList<>(courses);

        // printCourses(courses);
        courses.stream().forEach(System.out::println);

        //print all the courses with spring in name

       List<String> springInName = courses.stream()
                .filter(course ->course.contains("Spring"))
               .collect(toList());
        System.out.println("<<<<<<springInName >>>>>=" + springInName);

        //print all the word lengths in the list

     List<Integer> wordLength =    courses.stream()
             .map(course ->course.length())
             .collect(toList());
        System.out.println("<<<<courses>>>>>>"+courses);
        System.out.println("<<<<<<<wordLength>>>>>>>>"+ wordLength);



//print all the courses with length >4
        List<String> courseWithLenghtAtleast4 = courses.stream()
                .filter(course ->course.length()>4)
                        .collect(toList());
        System.out.println("<<<<<<courseWithLenghtAtleast4 >>>>>=" + courseWithLenghtAtleast4);

        // printAllUpperCase(courses);
        System.out.println("<<<<<print list in uppercase>>>>>>");
        courses.stream()
                .map(e -> e.toUpperCase())
                .forEach(System.out::println);

        List<String> toUpperStr =  courses.stream()
                .map(e -> e.toUpperCase())
                .map(x->x.concat("_kavitha_"))
               .filter((x->x.contains("SPRING")))
                .collect(toList());

        System.out.println("<<<<<kavitha toUpperStr"+ toUpperStr);



        List<String> courseList = courses.stream().map(e -> e.toUpperCase()).collect(Collectors.toList());
        System.out.println("<<<courseList>>>> = " + courseList);
        //courseListSize(courses);
        Long count = courses.stream().count();
        System.out.println(count);
        //  coursesAsc(coursesArrayList);

        List<String> courseAsc = coursesArrayList.stream().sorted().collect(Collectors.toList());
        System.out.println("<<<<< courseAsc>>>>" + courseAsc);
        // coursesDsc(coursesArrayList);

        List<String> courseDesc = coursesArrayList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println("<<<<< courseDesc>>>>" + courseDesc);


        Map<Integer, List<String>> map = coursesArrayList.stream().collect(Collectors.groupingBy(e -> e.length(), Collectors.mapping(x -> x.toUpperCase(), Collectors.toList())));
        System.out.println("<<<<map>>>> = " + map);

        SortedMap<Integer, List<String>> treeMap = new TreeMap<>(map);
        System.out.println("<<<<TreeMap>>>" + treeMap);
        //  findTheCourse(courses, "small");
        Integer shortKeyIndex = treeMap.firstKey();
        List<List<String>> shortwordsList = treeMap.entrySet().stream()
                .filter(entry -> entry.getKey() == shortKeyIndex)
                .map(entry -> entry.getValue())
                .collect(toList());
        System.out.println("The longest word length = " + shortKeyIndex + " The list of the longest words =" + shortwordsList);


        //  findTheCourse(courses, "long");
        Integer longwordKeyIndex = treeMap.lastKey();
        List<String> max;
        List<List<String>> longwordsList = treeMap.entrySet().stream()
                .filter(entry -> entry.getKey() == longwordKeyIndex)
                .map(entry -> entry.getValue())
                .collect(toList());
        System.out.println("The longest word length = " + longwordKeyIndex + " The list of the longest words =" + longwordsList);

    }







}
