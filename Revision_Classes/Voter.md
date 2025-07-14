import java.util.Scanner;
class VoterDetails
{
	private int age;
	public void setAge(int age){
		if(age >= 0 && age <= 18 ){
		System.out.println("not eligible");
		

					
		}
		else if(age >= 19 && age <= 100)
		{
				this.age=age;
				System.out.println("eligible ");

				
		}
		else{
			System.out.println("not eligible");
		}
			
	}
	
	
	
	public int getAge(){
		return age;
	}
		

}

class Voter {
	public static void main(String[] args) 
	{
	Scanner sc=new Scanner(System.in);
	   System.out.println("enter the age: ");
	   int i=sc.nextInt();
	   VoterDetails vd=new VoterDetails();
	   vd.setAge(i);
       int age=vd.getAge();


	}
}