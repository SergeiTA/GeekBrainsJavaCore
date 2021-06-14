package streamLesson.enities;

public class SimpleCourse implements Course {

    private String courseName;

    public SimpleCourse() {
    }

    public SimpleCourse(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String getCourseName() {
        return this.courseName;
    }

    @Override
    public String toString() {
        return "SimpleCourse{" +
                "courseName='" + courseName + '\'' +
                '}';
    }
}
