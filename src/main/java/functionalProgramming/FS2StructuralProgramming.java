package functionalProgramming;

import java.util.*;

public class FS2StructuralProgramming {
    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        List<String> coursesArrayList = new ArrayList<>(courses);
        printCourses(courses);
        printAllUpperCase(courses);
        countCourses(courses);
        System.out.println();
        courseListSize(courses);
        System.out.println();
        coursesAsc(coursesArrayList);
        System.out.println();
        coursesDsc(coursesArrayList);
        System.out.println();

        findTheCourse(courses, "small");
        findTheCourse(courses, "long");


    }

    private static void courseListSize(List<String> courses) {
        System.out.println("print the size of list ");
        System.out.println(courses.size());

    }

    private static void printCourses(List<String> courses) {
        System.out.println("print the size of each course name ");
        for (String str : courses) {
            System.out.print("[" + str + " : " + str.length() + "]");
        }
    }

    private static void findTheCourse(List<String> courses, String wordType) {
        System.out.println("<<<get the map from the courses list" + courses + ">>>");
        System.out.println("Courses list =" + courses );
        System.out.println("<<<<convert list to map>>>");
        Map<Integer, List<String>> map = getTheMapping(courses);
        System.out.println("<<<<sort the map>>>>");
        sortMap(map, wordType);
        System.out.println("<<<<<get the "+ wordType+" length words >>>>");
        getTheWordLength(map, wordType);

    }

    private static void sortMap(Map<Integer, List<String>> map, String wordType) {
        Map<Integer, List<String>> treeMap = new TreeMap<>();
        sortedTreeMap(map);
        printMapSortedByKey(map);

    }

    private static Map<Integer, List<String>> getTheMapping(List<String> courses) {
        Map<Integer, List<String>> map = new HashMap<>();

        for (String str : courses) {

            if (map.containsKey(str.length())) {
                List<String> ls = map.get(str.length());
                ls.add(str);
                map.put(str.length(), ls);
            } else {
                List<String> list2 = new ArrayList<>();
                list2.add(str);
                map.put(str.length(), list2);
            }
        }
        return map;
    }

    private static void getTheWordLength(Map<Integer, List<String>> map, String wordType) {
        int wordlength = 0;
        Map<Integer, List<String>> treeMap = new TreeMap<>();
        if (wordType.equals("small")) {
            sortedTreeMap(map);
            pickTheFirstKeyPair(map);
        } else {
            sortedTreeMap(map);
            pickTheLastKeyPair(map);
        }
    }

    private static void pickTheLastKeyPair(Map<Integer, List<String>> map) {
        Set<Map.Entry<Integer, List<String>>> mapValues = map.entrySet();
        int maplength = mapValues.size();
        Map.Entry<Integer, List<String>>[] test = new Map.Entry[maplength];
        mapValues.toArray(test);
        System.out.print("Longest length =" + test[maplength - 1].getKey()+"  and the longest value(s)=" + test[maplength - 1].getValue());
    }

    private static void pickTheFirstKeyPair(Map<Integer, List<String>> map) {

        Iterator<Integer> iterator = map.keySet().iterator();
        Integer wordlength = null;
        List<String> listOfWords = null;
        if (iterator.hasNext()) {
            wordlength = iterator.next();
            listOfWords = map.get(wordlength);
        }
        System.out.println("short Word(s) is of length=" + wordlength + " and the value(s)=" + listOfWords);
    }


    private static Map<Integer, List<String>> sortedTreeMap(Map<Integer, List<String>> map) {
        Map<Integer, List<String>> treeMapAsc = new TreeMap<Integer, List<String>>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }

        });

        treeMapAsc.putAll(map);
        return treeMapAsc;
    }



    private static List<String> printTheWord(Map<Integer, List<String>> map, int keyValue) {
        List<String> words = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            if (map.containsKey(keyValue)) {
                words = map.get(keyValue);
            }
        }
        return words;
    }


    public static <K, V> void printMapSortedByKey(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("[Key:Value]->" + entry.getKey() + ":" + entry.getValue() );
        }
    }

    private static void coursesDsc(List<String> courses) {
        System.out.println("print courses in dsc order");
        Collections.sort(courses, Collections.reverseOrder());
        System.out.println(courses);
    }

    private static void coursesAsc(List<String> courses) {
        System.out.println("list course names in Asc order");
        Collections.sort(courses);
        System.out.println(courses);

    }

    private static void countCourses(List<String> courses) {
        System.out.println("print the count of the courses listed");
        System.out.println(courses.size());
    }

    private static void printAllUpperCase(List<String> courses) {
        System.out.println("print all the courses in upper case");
        for (String str : courses) {
            System.out.println(str.toUpperCase());
        }

    }


}
