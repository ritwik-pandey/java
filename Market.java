import java.util.*;
class Market{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Scanner in1 = new Scanner(System.in);
		System.out.println("How many Items you have purchased");
		int items = in.nextInt();
		String[] item = new String[items];
		int[] quantity = new int[items];
		int[] price = new int[items];
		for(int i = 0 ; i < items ; ++i){
			System.out.print("Enter item name: ");
			item[i] = in1.nextLine();
			System.out.print("Enter item price: ");
			price[i] = in.nextInt();
			System.out.print("Enter item quantity: ");
			quantity[i] = in.nextInt();
		}
		int total1 = 0;
		int[] total = new int[items];
		for(int i = 0 ; i < items ; ++i){
			total[i] = quantity[i] * price[i];
			total1 = total1 + total[i];	
		}
		System.out.println("NO.	  Item	       Quantity	     Total price of that item");
		for(int i = 0 ; i < items ; ++i){
			System.out.println(i + "\t   " + item[i]  + "\t\t" + quantity[i] + "\t\t" + total[i]);
		}
		System.out.println("The amount to be paid = " + total1);
		System.out.println("Thanks for using");
	}
}
