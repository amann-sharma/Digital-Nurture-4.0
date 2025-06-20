public class MVCTest {
    public static void main(String[] args) {
        Student student = new Student("Aman", "S101", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);
        controller.updateView();
        controller.setStudentGrade("A+");
        System.out.println("\nAfter grade update:");
        controller.updateView();
    }
} 