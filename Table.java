import java.util.*;
class Table{
	public static void main(String[] args){
	Scanner in = new Scanner(System.in);
		System.out.println("ENTER THE NO WHOSE YOU WANT TO KNOW");
		int a = in.nextInt();
		System.out.println("ENTER THE NUMBER TILL WHERE YOU WANT TO KNOW THE TABLE");
		int b = in.nextInt();
		System.out.println("\n YOUR TABLE IS =");
		for(int i = 1;b >= i;++i){
			System.out.println(a +  " X "+ i + " = " + (a * i) );
		}
	}
}
