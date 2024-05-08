import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private static Catalog single_instance = new Catalog();
    public List<Course> courses = new ArrayList<Course>();

    private Catalog() {}

    public static Catalog Singleton() {
        return single_instance;
    }

    Catalog catalog = Catalog.Singleton();

    public void addCourse(Course course) {
        catalog.courses.add(course);
    }

    public void removeCourse(Course course) {
        catalog.courses.remove(course);
    }
}
