import java.util.*;

public class Group extends TreeSet<Student> {
    public Assistant assistant;
    public String ID;
    public TreeSet<Student> students;

    public Group(String ID, Assistant assistant, Comparator<Student> comp) {
        this.ID = ID;
        this.assistant = assistant;
        this.students = new TreeSet<Student>();
    }

    public Group(String ID, Assistant assistant) {
        this.ID = ID;
        this.assistant = assistant;
    }
}
