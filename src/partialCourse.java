import java.util.ArrayList;

public class partialCourse extends Course{
    public partialCourse(CourseBuilder builder) {
        super(builder);
    }

    @Override
    public ArrayList<Student> getGraduatedStudents() {
        ArrayList<Student> studArr = new ArrayList<>();
        for( Grade grade : getAllStudentGrades().values() )
            if(grade.getTotal() >= 5)
                studArr.add(grade.getStudent());
        return studArr;
    }
}
