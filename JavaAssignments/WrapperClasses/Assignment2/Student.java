public class Student {
String name;
Double mark1, mark2, mark3;

// Constructor

public Student(String name) {
this.name = name;
}


public void setMarks(String m1, String m2, String m3) {
try {
mark1 = parseAndValidate(m1, "Mark 1");
mark2 = parseAndValidate(m2, "Mark 2");
mark3 = parseAndValidate(m3, "Mark 3");
System.out.println("Marks set successfully for " + name);
} catch (InvalidMarkException e) {
System.out.println("Exception: " + e.getMessage());
} catch (NumberFormatException e) {
System.out.println("Exception: Invalid number format!");
}
}


private Double parseAndValidate(String markStr, String label) throws InvalidMarkException {
Double mark = Double.parseDouble(markStr);

if (mark < 0) {
throw new InvalidMarkException("Invalid mark: cannot be negative");
} else if (mark > 100) {
throw new InvalidMarkException("Invalid mark: cannot exceed 100");
}

return mark;
}


public double calculateAverage() {
return (mark1 + mark2 + mark3) / 3;
}

// Return grade based on average
public char getGrade() {
double avg = calculateAverage();

if (avg >= 90) return 'A';
else if (avg >= 75) return 'B';
else if (avg >= 60) return 'C';
else if (avg >= 40) return 'D';
else return 'F';
}
}
