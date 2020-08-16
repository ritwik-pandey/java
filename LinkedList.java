import java.util.*;
class Node{
	int data;	
	Node next;
}
class LinkedList{
	Node head;
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args){
		LinkedList obj = new LinkedList();
		int count = 1;
		while(count == 1){
			System.out.println("\n1: create\n2: Insert At End\n3: Insert At Front \n4: Display\n5: Search and delete \n6: Exit");
			int choice = in.nextInt();
			switch(choice){
				case 1:
					obj.create();
					break;
				case 2:
					if(obj.head == null){
						System.out.println("Create a LinkedList First");
					}
					else{
						System.out.println("Enter the data");
						int data = in.nextInt();
						obj.insertEnd(data);
					}
					break;
				case 3:
					if(obj.head == null){
						System.out.println("Create a LinkedList first");
					}
					else{
						System.out.println("Enter the data");
						int data = in.nextInt();
						obj.insertFront(data);
					}
					break;
				case 4:
					obj.display();
					break;
				case 5:
					if(obj.head == null){
						System.out.println("Create a LinkedList first");
					}
					else{
						System.out.println("Enter the data");
						int data = in.nextInt();
						obj.searchAndDelete(data);
					}
					break;
				case 6:
					obj.exit();
					break;
				default:
					System.out.println("Invalid Choice");
			}
		}
	}
	void create(){
		head = new Node();	
	       	head.data = in.nextInt();
		head.next = null;	
	}
	void insertEnd(int value) {
		Node headCopy = head;
		while(headCopy.next != null){
			headCopy = headCopy.next;
		}
		Node newNode = new Node();
		newNode.data = value;
		newNode.next = null;
		headCopy.next = newNode;
		display();
	}
	void insertFront(int value) {
		Node headCopy = head;
		Node newNode = new Node();
		newNode.data = value;
		headCopy = newNode;
		newNode.next = head;
		head = headCopy;
		display();
	}
	void display(){
		if(head == null){
			System.out.println("Create a LinkedList first!");
			return;
		}
		Node headCopy = head;
		while(headCopy.next != null){
			System.out.print(headCopy.data + " ");
			headCopy = headCopy.next;
		}
		System.out.print(headCopy.data + " ");
	}
	void searchAndDelete(int value) {
		if(head.data == value) {
			head = head.next;
			return;
		}
		boolean found = false;
		Node prevNode, delNode;
		prevNode = delNode = head;
		while(!found && delNode != null) {
			if(delNode.data == value) {
				while(prevNode.next != delNode) {
					prevNode = prevNode.next;
				}
				prevNode.next = delNode.next;
				found = true;
			}
			delNode = delNode.next;
		}
		if(!found) {
			System.out.println("Not found");
		}

	}
	/*void searchAndDelete(){
		if(head == null){
			System.out.println("Create a Linked List first !");
			return;
		}
		Node headCopy = head;
		System.out.println("Enter the data");
		int input= in.nextInt();
		if(headCopy.data == input){
			if(headCopy.next == null){
				headCopy = null;
				head = null;
				return;
			}
			head = head.next;
			headCopy.next = null;
			display();
			return;
		}
		Node extra = head;
		while(extra.data != input){
			if(extra.data == input){
				break;
			}
			if(extra.next == null){
				if(extra.data == input){
					break;
				}else{
					System.out.println("No such data was found");
					return;
				}
			}
			extra = extra.next;
		}
		while(headCopy.data != input){
			headCopy = headCopy.next;
		}
		if(headCopy.next == null){
			Node headCopy1 = head;
			while(headCopy1.next != headCopy){
				headCopy1 = headCopy1.next;
			}
			headCopy1.next = null;
			return;
		}
		Node headCopy1 = headCopy;
		headCopy1 = headCopy1.next;
		headCopy.data = headCopy1.data;
		headCopy.next = headCopy1.next;

	}*/
	void exit(){
		System.out.println("Thanks for using");
		System.exit(0);
	}
}
