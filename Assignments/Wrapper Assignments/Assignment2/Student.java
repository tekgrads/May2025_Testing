public class Student {
    private String name;
    private Double mark1;
    private Double mark2;
    private Double mark3;

    // Constructor
    public Student(String name) {
        this.name = name;
    }

    // Method to set marks after parsing and validation
    public void setMarks(String m1, String m2, String m3) {
        try {
            mark1 = parseAndValidate(m1);
            mark2 = parseAndValidate(m2);
            mark3 = parseAndValidate(m3);
        } catch (InvalidMarkException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Exception: Invalid number format!");
        }
    }

    // Helper method for parsing and validation
    private Double parseAndValidate(String markStr) throws InvalidMarkException, NumberFormatException {
        Double mark = Double.parseDouble(markStr);

        if (mark < 0) {
            throw new InvalidMarkException("Invalid mark: cannot be negative");
        }
        if (mark > 100) {
            throw new InvalidMarkException("Invalid mark: cannot exceed 100");
        }

        return mark;
    }

    // Method to calculate average of marks
    public double calculateAverage() {
        if (mark1 == null || mark2 == null || mark3 == null) {
            return 0.0;
        }
        return (mark1 + mark2 + mark3) / 3.0;
    }

    // Method to get grade based on average
    public char getGrade() {
        double avg = calculateAverage();

        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 60) return 'C';
        else if (avg >= 40) return 'D';
        else return 'F';
    }
}