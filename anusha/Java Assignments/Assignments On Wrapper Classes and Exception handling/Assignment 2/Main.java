// Main class to run test cases
public class Main {
    public static void main(String[] args) {
        Student s = new Student("Rahul");

        // Valid input
        s.setMarks("85", "95", "70");

        double avg = s.calculateAverage();
        char grade = s.getGrade();

        System.out.printf("Average: %.2f\n", avg);
        System.out.println("Grade: " + grade);

        // Negative mark
        s.setMarks("-10", "90", "80");

        // Invalid format
        s.setMarks("100", "abc", "90");
    }
}
