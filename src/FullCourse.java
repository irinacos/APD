import java.util.ArrayList;

public class FullCourse extends Course{
    public FullCourse(Course.CourseBuilder builder) {
        super(builder);
    }

    @Override
    public ArrayList<Student> getGraduatedStudents() {
        ArrayList<Student> studArr = new ArrayList<>();
        for( Grade grade : getAllStudentGrades().values() )
            if(grade.getPartialScore() >= 3 && grade.getExamScore() >= 2)
                studArr.add(grade.getStudent());
        return studArr;
    }
}
