import java.util.*;

public abstract class Course {
    public String name;
    public Teacher titular;
    public HashSet<Assistant> assistants;
    public TreeSet<Grade> grades;
    public HashMap<String, Group> groups;
    public int credit;

    public Course(CourseBuilder builder) {
        this.name = builder.name;
        this.titular = builder.titular;
        this.assistants = builder.assistants;
        this.grades = builder.grades;
        this.groups = builder.groups;
        this.credit = builder.credit;
    }

    public String getName() {
        return name;
    }

    public Teacher getTitular() {
        return titular;
    }

    public HashSet<Assistant> getAssitants() {
        return assistants;
    }

    public TreeSet<Grade> getGrades() {
        return grades;
    }

    public HashMap<String, Group> getGroups() {
        return groups;
    }

    public int getCredit() {
        return credit;
    }

    public static class CourseBuilder {
        private final String name;
        private final Teacher titular;

        private HashSet<Assistant> assistants;
        private TreeSet<Grade> grades;
        private HashMap<String, Group> groups;
        private int credit;

        public CourseBuilder(String name, Teacher titular) {
            this.name = name;
            this.titular = titular;
        }

        public CourseBuilder assistants(HashSet<Assistant> assistants) {
            this.assistants = assistants;
            return this;
        }

        public CourseBuilder grades(TreeSet<Grade> grades) {
            this.grades = grades;
            return this;
        }

        public CourseBuilder groups(HashMap<String, Group> groups) {
            this.groups = groups;
            return this;
        }

        public CourseBuilder credit(int credit) {
            this.credit = credit;
            return this;
        }

        public Course build() {
            return new Course(this) {
                @Override
                public ArrayList<Student> getGraduatedStudents() {
                    return null;
                }
            };
        }
    }

    // Seteaza asistentul în grupa cu ID-ul indicat
    // Daca nu exista deja, adauga asistentul si în multimea asistentilor
    public void addAssistant(String ID, Assistant assistant) {
        if (groups.get(ID) == null) {
            assistants.add(assistant);
        }
        groups.get(ID).assistant = assistant;
    }

    // Adauga studentul în grupa cu ID-ul indicat
    public void addStudent(String ID, Student student) {
        groups.get(ID).add(student);
    }

    // Adauga grupa
    public void addGroup(Group group) {
        this.groups.values().add(group);
    }

    // Instantiaza o grupa si o adauga
    public void addGroup(String ID, Assistant assistant) {
        Group group = new Group(ID, assistant);
        addGroup(group);
    }

    // Instant, iaza o grupa si o adauga
    public void addGroup(String ID, Assistant assist, Comparator<Student> comp) {
        Group group = new Group(ID, assist, comp);
        addGroup(group);
    }

    // Returneaza nota unui student sau null
    public Grade getGrade(Student student) {
        for (Grade g : this.grades)
            if (g.getStudent().equals(student))
                return g;
        return null;
    }

    // Adauga o nota
    public void addGrade(Grade grade) {
        this.grades.add(grade);
    }

    // Returneaza o lista cu toti studentii
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> arrStud = new ArrayList<>();
        for (Group group : this.groups.values())
            for (Student stud : group.students)
                arrStud.add(stud);
        return arrStud;
    }

    // Returneaza un dictionar cu situatia studentilor
    public HashMap<Student, Grade> getAllStudentGrades() {
        HashMap<Student, Grade> map = new HashMap<>();
        for (Student stud : getAllStudents())
            map.put(stud, getGrade(stud));
        return map;
    }

    // Metoda ce o sa fie implementata pentru a determina studentii promovati
    public abstract ArrayList<Student> getGraduatedStudents();
}
