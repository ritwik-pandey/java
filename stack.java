import java.util.*;
class stack{
	int a[];
	int size;
	int input = 0;
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args){
		stack obj = new stack();
		int WantToContinue = 1;
		do{
			System.out.println("\n1: create \n2: push \n3: pop \n4: display \n5: exit");
			int choice = in.nextInt();
			switch(choice){
				case 1: 
					obj.create();
					break;
				case 2:
					obj.push();
					break;
				case 3:
					obj.pop();
					break;
				case 4: 
					obj.display();
					break;
				case 5:
					obj.exit();
					break;
				default:
					System.out.println("Invalid choice");
			}
		}while(WantToContinue == 1);
	}
	void create(){
		System.out.println("Enter the size");
		size = in.nextInt();
		a = new int[size];
		display();
	}
	void display(){
		for(int  i = 0; i < size ; ++i){
			System.out.print(a[i] + " ");
		}
	}
	void push(){
		if(input >= size){
			System.out.println("Overflow");
			return;
		}
		System.out.println("\nEnter the value");
		a[input] = in.nextInt();
		++input;
		display();
	}
	void pop(){
		if(input == 0){
			System.out.println("Underflow");
			return;
		}
		System.out.println(a[input - 1]);
		a[input - 1] = 0;
		--input;
		display();
	}
	void exit(){
		System.out.println("\n\n-------------------Thanks for using---------------------");
		System.exit(0);
	}

}
