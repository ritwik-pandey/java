public class SortString {

    public static void SortArray(String a[]){
        Sort(a , 0);
    }

    public static void Sort(String a[] , int start){
        if(a.length == start){
            return;
        }
        int smallest = findSmallest(a , start) ;
        swap(start , smallest , a);
        Sort(a , start + 1);
    }
    public static void swap(int a , int b , String[] arr){
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static int findSmallest (String[] a , int start){
        int smallestIndex = start;
        for(int i = start ; i < a.length ; ++i){
            int cmp = a[i].compareTo(a[smallestIndex]);
            if(cmp < 0){
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}
