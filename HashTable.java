import java.util.*;
class Node<Key , Item>{
	Key key;
	Item item;
	Node<Key , Item> next;

	public Node(Key key , Item item){
		this.key = key;
		this.item = item;
	}

}

public class HashTable<K , V>{
	private ArrayList<Node<K , V>> list;
	private int maxSize;
	private int size;

	public HashTable(){
		list = new ArrayList<>();
		maxSize = 10;
		size = 0;

		for(int i = 0 ; i < maxSize ; ++i){
			list.add(null);
		}
	}

	public int getIndex(K key){
		int hashCode = key.hashCode();
		int index = hashCode % maxSize;
		return index;
	}

	public void insert(K key , V value){
		int listIndex = getIndex(key);
		Node<K , V> head = list.get(listIndex);

		while(head != null){
			if(head.key.equals(key)){
				head.item = value;
				return;
			}
			head = head.next;
		}
		++size;
		head = list.get(listIndex);
		Node<K , V> newNode = new Node<>(key , value);
		newNode.next = head;
		list.set(listIndex , newNode);

		if((size/maxSize) >= 1){
			ArrayList<Node<K , V>> temp = list;
			list = new ArrayList<>();
			maxSize = maxSize * 2;
			size = 0;

			for(int i = 0 ; i < maxSize ; ++i){
				list.add(null);
			}

			for(Node<K , V> headCopy : temp){
				while(headCopy != null){
					insert(headCopy.key , head.item);
					head = headCopy.next;
				}
			}
		}
	}

	public void print(){
		for(Node<K , V> headCopy : list){
			while(headCopy != null){
				System.out.println("Key: " + headCopy.key + " Value: " + headCopy.item);
				headCopy = headCopy.next;
			}
		}
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public static void main(String[] args){
		HashTable<Integer , String> table = new HashTable<>();
		table.insert(1 , "Hello");
		table.insert(2 , "Bye");
		table.print();
	}

}
