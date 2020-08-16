import java.util.*;
class queue{
	static Scanner in = new Scanner(System.in);
	int a[];
	int n;
	int count = 0;
	int front = 0;
	int rear = 0;
	public static void main(String[] args){
		queue obj = new queue();
		obj.create();
		int WantToContinue = 1;
		while(WantToContinue == 1){
			System.out.println("\n1.create \n2. enqueue \n3. dequeue \n4. display \n5. exit");
			int choice = in.nextInt();
			switch(choice){
				case 1: 
					obj.create();
					break;
				case 2:
					obj.enqueue();
					break;
				case 3:
					obj.dequeue();
					break;
				case 4: 
					obj.display();
					break;
				case 5 :
					obj.exit();
					break;
				default:
					System.out.println("Wrong input");
			}
		}
	}
	void create(){
		System.out.println("\nEnter the size of queue");
		n = in.nextInt();
		a = new int[n];
		display();
	}
	void display(){
		for(int i = 0 ; i < n ; ++i){
			System.out.print(a[i] +  " ");
		}
	}
	void enqueue(){
		if(count == n){
			System.out.println("Queue is full");
			return;
		}
		System.out.println("Enter the data");
		int data = in.nextInt();
		a[front] = data;
		++front;
		display();
	}
	void dequeue(){
		if(rear == front){
			System.out.println("Queue is empty");
			return;
		}
		System.out.println(a[rear]);
		a[rear] = 0;
		++rear;
		display();
	}
	void exit(){
		System.out.println("---------------------Thanks for using---------------------");
		System.exit(0);
	}
}

