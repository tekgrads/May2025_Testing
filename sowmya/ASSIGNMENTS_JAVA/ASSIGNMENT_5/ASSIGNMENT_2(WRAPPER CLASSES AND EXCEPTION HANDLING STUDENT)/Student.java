// Simple Java Program: Student Grade Analyzer

class InvalidMarkException extends Exception {
    public InvalidMarkException(String msg) {
        super(msg);
    }
}

class StudentInfo {
    String name;
    Double mark1, mark2, mark3;

    StudentInfo(String name) {
        this.name = name;
    }

    void setMarks(String m1, String m2, String m3) {
        try {
            mark1 = checkMark(m1);
            mark2 = checkMark(m2);
            mark3 = checkMark(m3);
        } catch (InvalidMarkException e) {
            System.out.println( e.getMessage());
        }
    }

    Double checkMark(String markStr) throws InvalidMarkException {
        try {
            double m = Double.parseDouble(markStr);
            if (m < 0 || m > 100)
                throw new InvalidMarkException("Exception: Invalid mark: cannot be negative ");
            return m;
        } catch (NumberFormatException e) {
            throw new InvalidMarkException("Exception: Invalid number format!");
        }
    }

    double calculateAverage() {
        return (mark1 + mark2 + mark3) / 3;
    }

    char getGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 60) return 'C';
        else if (avg >= 40) return 'D';
        else return 'F';
    }
}

public class Student {
    public static void main(String[] args) {
        StudentInfo s = new StudentInfo("Rahul");

        // Test 1: Valid
        s.setMarks("85", "95", "70");
        System.out.println("Average: " + s.calculateAverage());
        System.out.println("Grade: " + s.getGrade());

        // Test 2: Negative mark
        s.setMarks("-10", "90", "80");
        

        // Test 3: Invalid format
        s.setMarks("100", "abc", "90");
    }
}
