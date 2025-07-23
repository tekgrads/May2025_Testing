/*   Develop a project to implement Inheritance, Enucapsulation and Polymorphsim
    in single object development for example Shape

	Develop overriding wise polymorphism 
	for the method Shape.findArea() 
	*/
	class Shape
	{
		void findArea(){  }
	}
	
	class Rectangle extends Shape
	{
		private double length;
		private double breadth;
		
		Rectangle(double length, double breadth){
			this.length = length;
			this.breadth = breadth;
		}
		void findArea(){
			System.out.println("The area of rectangle is : " + (length* breadth));
		}
	}
	
	class Square extends Shape
	{
		private double side;
		Square(double side){
			this.side = side;
		}
		void findArea(){
			System.out.println("The area of square is: " + side * side);
		}
	}
class  Test2_Painter
{
	public static void main(String[] args) 
	{
		Shape s1 = new Rectangle(15.9, 10.2);
		s1.findArea();
		Shape s2 = new Square(20);
		s2.findArea();
	}
}
