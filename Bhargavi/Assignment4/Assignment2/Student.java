public class Student {
    String name;
    Double mark1, mark2, mark3;

    
    public Student(String name) {
        this.name = name;
    }

    
    public void setMarks(String m1, String m2, String m3) {
        try {
            mark1 = parseAndValidate(m1);
            mark2 = parseAndValidate(m2);
            mark3 = parseAndValidate(m3);
        } catch (InvalidMarkException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

  
    private Double parseAndValidate(String markStr) throws InvalidMarkException {
        double mark;
        try {
            mark = Double.parseDouble(markStr); 
        } catch (NumberFormatException e) {
            throw new InvalidMarkException("Invalid number format!");
        }

        if (mark < 0) {
            throw new InvalidMarkException("Invalid mark: cannot be negative");
        } else if (mark > 100) {
            throw new InvalidMarkException("Invalid mark: cannot be greater than 100");
        }

        return mark;
    }

   
    public double calculateAverage() {
        return (mark1 + mark2 + mark3) / 3;
    }

   
    public char getGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 60) return 'C';
        else if (avg >= 40) return 'D';
        else return 'F';
    }
}
