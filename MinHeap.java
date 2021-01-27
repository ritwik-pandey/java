class MinHeap{
	private int[] elements;
	private int size;
	private int maxsize;
	
	public MinHeap(int maxsize){
		elements = new int[maxsize + 1];
		size = 0;
		this.maxsize = maxsize;
		elements[0] = Integer.MIN_VALUE;
	}

	public int parent(int index){
		return index / 2 ;
	}

	public int rightChild(int position){
		return 2 * position + 1;
	}

	public int leftChild(int position){
		return 2 * position;
	}

	public boolean isLeaf(int position){
		if(position >= size/2 && position <= size){
			return true;
		}
		return false;
	}

	public void swap(int index , int index2){
		int temp = index;
		elements[index] = elements[index2];
		elements[index2] = temp;
	}

	public void insert(int elementToInsert){
		if(size >= maxsize){
			System.out.println("Heap is already full please remove an element");
			return;
		}
		elements[++size] = elementToInsert;
		int a = size;
		while(elements[a] <  elements[parent(a)]){
			swap(a , parent(a));
			a = parent(a);
		}
	}

	public void heapify(int p){
		if(!isLeaf(p)){
			if(elements[p] > elements[leftChild(p)] || elements[p] > elements[rightChild(p)]){
				if(elements[leftChild(p)] > elements[rightChild(p)]){
					swap(p , rightChild(p));
					heapify(rightChild(p));
				}else{
					swap(p , leftChild(p));
					heapify(leftChild(p));
				}
			}
		}
	}

	public int getSmallest(){
		return elements[1];
	}

	public int getLargest(){
		return elements[size - 1];
	}

	public void deleteMin(){
		elements[1] = elements[size--];
		heapify(1);
	}

	public void print(){
        	for (int i = 1 ; i <= size ; ++i){
			System.out.print(elements[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args){
		MinHeap heap = new MinHeap(3);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.print();
		heap.deleteMin();
		heap.print();
	}
}
