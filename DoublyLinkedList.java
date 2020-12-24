import java.util.*;
public class DoublyLinkedList{
	public NodeList sentinel;
	public NodeList sentinelLast;
	public class NodeList{
		NodeList prev;
		int item;
		NodeList next;
		public  NodeList(NodeList p , int i , NodeList n){
			prev = p;
			item = i;
			next = n;
		}
	}
	public DoublyLinkedList(){
		sentinel = new NodeList(null , 70 , null);
		sentinelLast = new NodeList(null ,70, sentinel);
		sentinel.prev = sentinelLast;
	}
	public void add(int a){
		if(sentinel.next == null){
			sentinel.next = new NodeList(sentinel , a , sentinelLast);
			sentinelLast.prev = sentinel.next;
			return;
		}
		sentinel.next = new NodeList(sentinel , a , sentinel.next);
		sentinel.next.next.prev = sentinel.next;
	}
	public void addLast(int a){
		if(sentinel.next == null){
			sentinel.next = new NodeList(sentinel , a , sentinelLast);
			sentinelLast.prev = sentinel.next;
			return;
		}
		sentinelLast.prev = new NodeList(sentinelLast.prev , a , sentinelLast);
		sentinelLast.prev.prev.next = sentinelLast.prev;
	}
	public void getLast(){
		if(sentinelLast.prev == null){
			System.out.println("Last elemrnt don't exist");
			return;
		}
		System.out.println("Last element is = " + sentinelLast.prev.item);
	}
	public void getFirst(){
		if(sentinel.next == null){
			System.out.println("First element don't exist");
			return;
		}
		System.out.println("First Element is = " + sentinel.next.item);
	}
	public void print(){
		NodeList p = sentinel.next;
		while(p != sentinelLast && p != null){
			System.out.println(p.item + " ");
			p = p.next;
		}
	}
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		DoublyLinkedList list = new DoublyLinkedList();
		int choice;
		do{
			System.out.println("1:Input element at front\n2:Input element at last\n3:Get first Elementn\n4:Get last element\n5: Print the list\n0: Exit");
			choice = in.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter number to add");
					int b = in.nextInt();
					list.add(b);
					break;
				case 2:
					System.out.println("Enter number to add");
               		                int c = in.nextInt();
              	                  	list.addLast(c);
					break;
				case 3:
					list.getFirst();
					break;
				case 4:
					list.getLast();
					break;
				case 5:
					list.print();
					break;
				case 0 : 
					System.out.println("Bye");
					break;
				default:
					System.out.println("You entered a wrong number");

			}
		}while(choice != 0);
/*		list.add(56);
		list.add(54);
		list.add(52);
		list.addLast(58);
		list.addLast(60);
		list.getLast();
		list.getFirst();
		list.print();	*/	
	}
}
