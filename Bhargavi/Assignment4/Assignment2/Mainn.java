public class Mainn {
    public static void main(String[] args) {
        Student s = new Student("Rahul");

        s.setMarks("85", "95", "70");
        double avg = s.calculateAverage();
        char grade = s.getGrade();
        System.out.println("Average: " + String.format("%.2f", avg));
        System.out.println("Grade: " + grade);

     
        s.setMarks("-10", "90", "80");

       
        s.setMarks("100", "abc", "90");
    }
}
