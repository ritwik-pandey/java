import java.util.*;
class Function_cube{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int cube2;
		System.out.println("How many number cube you want to find");
		int n = in.nextInt();
		System.out.println("Enter the number");
		for(int i = 0 ; i < n ; ++i){
			int a = in.nextInt();
			cube2 =  cube(a);
			System.out.println("Cube of number " + a + " = " + cube2);
		}
	}
	public static int cube(int a){
		int b = a * a * a;
		return(b);
	}
}
