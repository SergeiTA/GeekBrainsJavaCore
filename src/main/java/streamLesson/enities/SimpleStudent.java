package streamLesson.enities;

import java.util.List;

public class SimpleStudent implements Student {

    private String name;
    private List<Course> listOfCourses;

    public SimpleStudent(String name, List<Course> listOfCourses) {
        this.name = name;
        this.listOfCourses = listOfCourses;
    }

    public SimpleStudent() {
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Course> getAllCourses() {
        return this.listOfCourses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListOfCourses(List<Course> listOfCourses) {
        this.listOfCourses = listOfCourses;
    }

    @Override
    public String toString() {
        return "SimpleStudent{" +
                "name='" + name + '\'' +
                ", listOfCourses=" + listOfCourses +
                '}';
    }
}
