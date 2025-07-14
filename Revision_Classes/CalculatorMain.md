class Addition { 
public int add(int a, int b) { 
    return a + b; 
	} 
}
class Subtraction { 
public int subtract(int a, int b) { 
    return a - b; 
    }  
}
class Multiplication { 
public int multiply(int a, int b) { 
    return a * b; 
	} 
}
class Division { 
public double divide(int a, int b) { 
    if (b != 0) { 
	return (double) a / b; 
	} else { 
	System.out.println("Cannot divide by zero."); 
	return 0; 
	}
	} 
	}
public class CalculatorMain { 
public static void main(String[] args) {
	Addition add = new Addition(); 
	Subtraction sub = new Subtraction(); 
	Multiplication mul = new Multiplication(); 
	Division div = new Division();
    int x = 20;
    int y = 30;

    System.out.println("Addition: " + add.add(x, y));
    System.out.println("Subtraction: " + sub.subtract(x, y));
    System.out.println("Multiplication: " + mul.multiply(x, y));
    System.out.println("Division: " + div.divide(x, y));
}
}