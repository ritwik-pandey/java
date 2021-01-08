public class QuickUnionDS implements DisjointSet{
    private int parent[];
    private int size[];

//    Constructor for the QuickUnionDS set

    public QuickUnionDS(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = -1;
            size[i] = 1;
        }
    }

    private int find(int a){
        int b = a;
        while(parent[b] >= 0){
            if(parent[parent[b]] != -1)
            parent[b] = parent[parent[b]];
            b = parent[b];
        }
        return b;
    }

//    Check if two values are connected
    @Override
    public boolean isConnected(int p , int q){
        return find(p) == find(q);
    }

//    Connect two values

    @Override
    public void connect(int p , int q){
        int i = find(p);
        int j = find(q);
        if(i == j){
            return;
        }
        if(size[i] < size[j]){
            parent[i] = j;
            size[j] = size[i] + size[j];
        }else{
            parent[j] = i;
            size[i] = size[j] + size[i];
        }
    }

    public static void main(String[] args){
        QuickUnionDS a = new QuickUnionDS(6);
        a.connect(1,2);;
        System.out.println(a.isConnected(2,3));
        a.connect(2,3);
        a.connect(1,5);
        System.out.println(a.isConnected(2,5));
    }
}
