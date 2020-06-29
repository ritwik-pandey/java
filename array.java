import java.util.*;
class array{
	Scanner in = new Scanner(System.in);
	int[] array;
	int N;
	public static void main(String[] args){
		array obj = new array();
		obj.create();
		int WantToContinue = 1;
		Scanner in1 = new Scanner(System.in);
		do{
			System.out.println("\nEnter 1 to create a new array");
			System.out.println("Enter 2 to write");
			System.out.println("Enter 3 to edit the data in array");
			System.out.println("Enter 4 to display the data in array");
			System.out.println("Enter 5 to insert a data in array");
			System.out.println("Enter 6 to see the size");
			System.out.println("Enter 7 to exit");
			int choice = in1.nextInt();
			switch(choice){
				case 1:
					obj.create();
					break;
				case 2:
					obj.write();
					break;
				case 3:
					obj.edit();
					break;	
				case 4:
					obj.display();
					break;
				case 5:
					obj.insert();
					break;
				case 6:
					obj.size();
					break;
				case 7:
					obj.exit();
					break;
				default:
					System.out.println("Invalid choice");
				
			}
			System.out.println("\nPress 1 to continue anything else to exit");
			WantToContinue = in1.nextInt();
		}while(WantToContinue == 1);
	}
	void create(){
		System.out.println("Enter the size of the array");
		N = in.nextInt();
		array = new int[N];
		display();
	}
	void write(){
		System.out.println("Input:");
		for(int i = 0 ; i < N ; ++i){
			array[i] = in.nextInt();
		}
		display();
	}
	void display(){
		for(int i = 0 ; i < N ; ++i){
			System.out.print(array[i] + " ");
		}
	}
	void edit(){
		System.out.println("Enter the index number");
		int index = in.nextInt();
		if(index > N){
			System.out.println("Out of bounds");
			return;
		}
		System.out.println("Enter the new data");
		array[index - 1] = in.nextInt();
		display();
	}
	void insert(){
		System.out.println("Enter the index number to insert");
		int index = in.nextInt();
		if(index > N){
			System.out.println("Out of bounds");
			return;
		}
		int arraycopy[] = new int [N];
		for(int i = 0 ; i < N ; ++i){
			arraycopy[i] = array[i];
		}
		N = N + 1;
		array = new int [N];
		System.out.println("Enter your data");
		int data = in.nextInt();
		for(int i = 0  ; i < N - 1 ; ++i){
			array[i] = arraycopy[i];
		}
		for(int i = N - 1; i > index ; --i ){
			array[i] = array[i - 1];
		}
		array[index] = data;
		display();
	}
	void size(){
		System.out.println(N);
	}
	void exit(){
		System.out.println("Thanks for using");
		System.exit(0);
	}
}
