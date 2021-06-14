package streamLesson;

import collectionsJC.TestArray;
import streamLesson.enities.Course;
import streamLesson.enities.SimpleCourse;
import streamLesson.enities.SimpleStudent;
import streamLesson.enities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamLessonRunner {


    public static void main(String[] args) {

        try {
            List<Student> studentList = makeExampleStudentsList(5);
            System.out.println(studentList);
            System.out.println("-----------------");
            System.out.println("Названия уникальных курсов, на которые подписаны студенты :");
            System.out.println(uniqueCoursesNames(studentList));

            System.out.println("-----------------");
            System.out.println("Список из трех самых любознательных студентов :");
            System.out.println(mostCuriousStudents(studentList));

            System.out.println("-----------------");
            System.out.println("Список студентов у которых есть курс из введенных аргументов");
            //Захардкодил название курса для демонстрации. Не всегда присутствует в рандомно распределении
            System.out.println(studentsHaveCourse(studentList, "Java0"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //В будущем при необходимости можно будет доавить конструкторы курсов и изменить/перегрузить этот метод
    private static SimpleCourse makeCourse(String courseName) throws Exception {
        simpleNullCheck(courseName);

        return new SimpleCourse(courseName);
    }

    //В будущем при необходимости можно будет доавить конструкторы курсов и изменить/перегрузить этот метод
    private static SimpleStudent makeStudent(String studentName, String courseName, int numberOfCourses) throws Exception {
        simpleNullCheck(studentName);
        simpleNullCheck(courseName);
        if (numberOfCourses <= 0) {
            throw new Exception("Введено не верное количество курсов");
        }

        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < numberOfCourses; i++) {
            courses.add(makeCourse(courseName + i));
        }
        return new SimpleStudent(studentName, courses);
    }

    //Генерируем пример списка студентов для наглядности отработки задач в ДЗ
    private static List<Student> makeExampleStudentsList (int numberOfStudents) throws Exception {
        if (numberOfStudents <= 0 || numberOfStudents > 10) {
            throw new Exception("Склишком большое количество студентов");
        }

        List<Student> studentList = new ArrayList<>();
        Random random = new Random();
        TestArray studentsNameExamples = new TestArray();
        String[] coursesNameExamples =  { "Java", "JS", "Python", "MySQL" };

        for (int i = 0; i < numberOfStudents; i++) {
            String tempStudentName = studentsNameExamples.repeatedStrings[i];
            studentList.add(makeStudent(
                    tempStudentName
                    , coursesNameExamples[random.nextInt(coursesNameExamples.length)]
                    , random.nextInt(10) + 1));
        }

        return studentList;

    }

    //Возвращаем названия уникальных курсов, на которые подписаны студенты
    private static List<String> uniqueCoursesNames (List<Student> listOfStudents) throws Exception {
        simpleNullCheck(listOfStudents);

        return listOfStudents.stream()
                .map(Student::getAllCourses)
                .flatMap(List::stream)
                .map(Course::getCourseName)
                .distinct()
                .collect(Collectors.toList());

    }

    //Возвращаем список из трех самых любознательных студентов
    private static List<Student> mostCuriousStudents (List<Student> listOfStudents) throws Exception {
        simpleNullCheck(listOfStudents);

        return listOfStudents.stream()
                .sorted(((o1, o2) -> o2.getAllCourses().size() - o1.getAllCourses().size()))
                .limit(3)
                .collect(Collectors.toList());
    }

    //Возвращаем список студентов у которых есть курс из введенных аргументов
    private static List<Student> studentsHaveCourse(List<Student> listOfStudents, String courseName) throws Exception {
        simpleNullCheck(listOfStudents);

        return listOfStudents.stream()
                //По какой-то причине просто .contains не выдавало нужный результат
                // , но после приведения списка строк к строке - все ок
                .filter(x -> x.getAllCourses().toString().contains(courseName))
                .collect(Collectors.toList());

    }

    private static void simpleNullCheck (Object objectForCheck) throws Exception {
        if (objectForCheck == null) {
            throw new Exception("Введенный аргумент является NULL");
        }
    }


}
