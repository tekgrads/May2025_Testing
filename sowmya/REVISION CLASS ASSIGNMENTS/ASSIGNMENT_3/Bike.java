//bike gear number should be 0-5
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
       Scanner scn=new Scanner(System.in);
	   System.out.println("enter the gear number");
	   int gno=scn.nextInt();
	   BikeDetails b=new BikeDetails();
	   b.setGearno(gno);
	   System.out.println("bike is running in gear number is: "+b.getGearno());
	}
}
