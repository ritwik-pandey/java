import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArraySet<T> implements Iterable<T>{

    private T[] items;
    private int size;

    public ArraySet(){
        items = (T[]) new Object[100];
    }

//    Returns true if this map contains a mapping for the specified Key
    public boolean contains(T x){
        for(int i = 0 ; i < size ; ++i){
            if(items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

//    Associates the specified value with the specified Key in this map
//    Throws exception when someone tries to add null

    public void add(T x){
        if(x == null){
            throw new IllegalArgumentException("You can't add null to Arrayset.");
        }
        if(contains(x)){
            return;
        }
        items[size] = x;
        ++size;
    }

//    Returns the size of the map

    public int size(){
        return size;
    }
//    return an iterator
    public Iterator<T> iterator(){
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T>{
        private int wizPos;
        public ArraySetIterator(){
            wizPos = 0;
        }
        public boolean hasNext(){
            return wizPos < size;
        }
        public T next(){
            T returnItem = items[wizPos];
            ++wizPos;
            return returnItem;
        }
    }

//    @Override
//    public String toString(){
//        StringBuilder returnString = new StringBuilder("{");
//        for(int i = 0 ; i < size - 1 ; ++i){
//            returnString.append(items[i].toString());
//            returnString.append(",");
//        }
//        returnString.append(items[size - 1]);
//        returnString.append("}");
//        return returnString.toString();
//    }
    @Override
    public String toString() {
        List<String> list = new ArrayList<>();
        for(T x : this){
            list.add(x.toString());
        }
        return "{" + String.join("," , list) + "}";
    }

    public static <Glerp> ArraySet<Glerp> of(Glerp... stuff){
        ArraySet<Glerp> returnSet = new ArraySet<>();
        for(Glerp x: stuff){
            returnSet.add(x);
        }
        return returnSet;
    }

    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if(other == null){
            return false;
        }
        if(other.getClass() != this.getClass()){
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if(o.size() != this.size()){
            return false;
        }
        for(T item: this){
            if(!o.contains(item)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        ArraySet<Integer> s = new ArraySet<>();
        s.add(5);
        s.add(23);
        s.add(42);

        ArraySet<Integer> s2 = new ArraySet<>();
        s2.add(5);
        s2.add(23);
        s2.add(42);
        System.out.println(s.equals(s2));
//        Iterator<Integer> aseer = s.iterator();
//        while(aseer.hasNext()){
//            int i = aseer.next();
//            System.out.println(i);
//        }
//
//        for(int i : s){
//            System.out.println(i);
//        }
        System.out.println(s);
        ArraySet<String> aset = ArraySet.of("hi" , "I'm" , "here" );
        System.out.println(aset);

    }
}
