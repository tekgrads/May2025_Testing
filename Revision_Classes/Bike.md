import java.util.Scanner;
class BikeDetails
{
	private int gearno;
	public void setGearno(int gearno){
		
		if(gearno >= 0 && gearno <= 5 ){
					this.gearno=gearno;
		}
		else{
			System.out.println("display in between 0 to 5");

		}				
	}
	
	
	
	public int getGearno(){
		return gearno;
	}
		

}



class Bike
{
	public static void main(String[] args) 
	{
       Scanner sc=new Scanner(System.in);
	   System.out.println("enter the gear number");
	   int gno=sc.nextInt();
	   BikeDetails b=new BikeDetails();
	   b.setGearno(gno);
	   System.out.println("bike is running in gear number is: "+b.getGearno());
	}
}