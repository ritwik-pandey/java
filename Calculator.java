import java.util.*;
class Calculator{
	public static void main(String[] args){
		Menu();
	}
	public static void Menu(){
		Scanner in = new Scanner(System.in);
		System.out.println("\n	Welcome to the calculator");
		try{Thread.sleep(2000);}catch(InterruptedException ex){}
		System.out.println("Press 1 for Addition");
		System.out.println("Press 2 for Subtraction");
		System.out.println("Press 3 for Multiplication");
		System.out.println("Press 4 for division");
		System.out.println("Press 5 for factorial");
		System.out.println("Press 6 to quit");
		int choice = in.nextInt();
		Main(choice);
	}
	public static void Main(int choice){
		Scanner in = new Scanner(System.in);
		switch(choice){
			case 1:
				try{Thread.sleep(2000);}catch(InterruptedException ex){}
				System.out.println("How many numbers you want to add");
				int n = in.nextInt();
				int[] add = new int[n];
				int sum = 0;
				System.out.println("Enter the numbers");
				for(int i = 0; i < n ; ++i){
					add[i] = in.nextInt();	
				}
				System.out.println("You have entered");	
				for(int i = 0 ; i < n ; ++i){
					System.out.print(add[i] + " ");
					sum = sum + add[i];
				}
				System.out.println("\nSum is " + sum);
				Menu();
				break;
			case 2:
				try{Thread.sleep(2000);}catch(InterruptedException ex){}
				System.out.println("Enter two number for subtraction");
				int sub = in.nextInt();
				int sub1 = in.nextInt();
				System.out.println("The number is: " + (sub - sub1));
				Menu();
				break;
			case 3:
				try{Thread.sleep(2000);}catch(InterruptedException ex){}
				System.out.println("How many numbers you want to enter");
                                n = in.nextInt();
				int s = 1; 
                                int[] multiply = new int[n];
                                System.out.println("Enter your numbers");
                                for(int i = 0 ; i < n ; ++i){
     		                           multiply[i] = in.nextInt();	
				}
              		        System.out.println("You have entered");
                                for(int j = 0; j < n ; ++j){
	                                System.out.println(multiply[j] + "  " );
                                        s = s * multiply[j];
                                 }
                                 System.out.println("Product is " + s);
				 Menu();
                                 break;
			case 4:
				 try{Thread.sleep(2000);}catch(InterruptedException ex){}
				 System.out.println("Enter the divisior");
				 int div = in.nextInt();
				 System.out.println("Enter the dividend");
				 int divd = in.nextInt();
				 System.out.println("Qutioent: " + divd / div);
				 System.out.println("Remainder: " + divd % div );
				 Menu();
				 break;
			case 5:
				 try{Thread.sleep(2000);}catch(InterruptedException ex){}
				System.out.println("Enter the number for factorial");
				int fac = in.nextInt();
				int factorial = 1;
				for(int i = 1 ; i <= fac ; ++i){
					factorial = factorial * i;
				}
				System.out.println("Factorial = " + factorial);
				Menu();
				break;
			case 6:
				try{Thread.sleep(500);}catch(InterruptedException ex){}
				System.out.println("Thanks for using");
				break;
			default:
				System.out.println("Wrong choice");
				Menu();
				break;
		}
	}
}
