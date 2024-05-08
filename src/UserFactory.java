public class UserFactory {
    public static User getUser(String userName, String firstName, String lastName) {
        if (userName.equals("Parent"))
            return new Parent(firstName, lastName);
        if (userName.equals("Student"))
            return new Student(firstName, lastName);
        if (userName.equals("Assistant"))
            return new Assistant(firstName, lastName);
        if (userName.equals("Teacher"))
            return new Teacher(firstName, lastName);
        return null;
    }
}
