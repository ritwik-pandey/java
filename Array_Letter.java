import java.util.*;
class Array_Letter{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Scanner in1 = new Scanner(System.in);
		boolean c = false;
		System.out.println("How many names do you want to enter");
		int n = in.nextInt();
		String[] name = new String[n];
		System.out.println("Enter the name");
		for(int i = 0 ; i < n ; ++i){
			name[i] = in1.nextLine();
		}
		String b;
		System.out.println("Enter a letter");
		String main = in1.nextLine();
		char d;
		d = main.charAt(0);
		for(int i = 0 ; i < n ; ++i){
			b = name[i];
			if(b.charAt(0) == d){
				System.out.println(b);
				c = true;
			}
		}
		if(c == false){
			System.out.println("No names were found");
		}
	}
}
