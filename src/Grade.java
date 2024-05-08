public class Grade implements Comparable, Cloneable {
    private Double partialScore, examScore;
    private Student student;
    private String course; // Numele cursului

    public Grade() {
        //this.partialScore = partialScore;
        //this.examScore = examScore;
        //this.course = course;
        //this.student = new Student(null, null);
    }

    public double getPartialScore() {
        return partialScore;
    }

    public double getExamScore() {
        return examScore;
    }

    public void setPartialScore(double partialScore) {
        this.partialScore = partialScore;
    }

    public void setExamScore(double examScore) {
        this.examScore = examScore;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Double getTotal() {
        return partialScore + examScore;
    }

    @Override
    public int compareTo(Object o) {
        Grade obj = (Grade) o;
        return (int) (this.getTotal() - obj.getTotal());
    }

    @Override
    public Grade clone() {
        return new Grade();
    }
}
