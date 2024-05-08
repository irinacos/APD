import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Catalog catalog = Catalog.Singleton();
        try {
            File file = new File("test1.txt");
            Scanner scanner = new Scanner(file);
            int nrCourses = Integer.parseInt(scanner.nextLine());

            for(int i = 1; i <= nrCourses; i++) {

                Course curs = new Course.CourseBuilder(scanner.nextLine(), new Teacher(scanner.next(), scanner.next())).build();
                catalog.courses.add(curs);
                int nrGrupe = Integer.parseInt(scanner.nextLine());

                for(int j = 1; j <= nrGrupe; j++) {
                    String id = scanner.nextLine();
                    Assistant assistant = new Assistant(scanner.next(), scanner.next());
                    curs.addGroup(id, assistant);
                    curs.addAssistant(id, assistant);

                    int nrStudenti = Integer.parseInt(scanner.nextLine());
                    for(int k = 1; k <= nrStudenti; k++) {
                        Student student = new Student(scanner.next(), scanner.next());
                        curs.addStudent(id, student);
                    }
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }
}