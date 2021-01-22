public class RedBlackTree{
    public class Node{
        int data;
        Node parent;
        Node left;
        Node right;
        int color;//1 for red 0 for black
        int repeat;
    }
    private Node root;
    private Node TNULL;

    public RedBlackTree(){
        TNULL = new Node();
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    public void put(int data){
        insert(data , 1);
    }

    public void put(int data , int repeat){
        insert(data , repeat);
    }

    private void insert(int data , int repeatValue){

        Node contains = containshelper(root , data);

        if(contains != null){
            ++contains.repeat;
            return;
        }

        Node node = new Node();
        node.data = data;
        node.right = TNULL;
        node.left = TNULL;
        node.color = 1;
        node.parent = null;
        node.repeat = repeatValue;

        Node y = null;
        Node x = this.root;

        while(x != TNULL){
            y = x;
            if(node.data < x.data){
                x = x.left;
            }else{
                x =x.right;
            }
        }

        node.parent = y;
        if(y == null){
            root = node;
        }else if(y.data > node.data){
            y.left = node;
        }else{
            y.right = node;
        }

        if(node.parent == null){
            node.color = 0;
            return;
        }
        if(node.parent.parent == null){
            return;
        }

        fixInsert(node);
    }

    private void fixInsert(Node k){
        Node u;
        while (k.parent.color == 1) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left;
                if (u.color == 1) {

                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right;

                if (u.color == 1) {

                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {

                        k = k.parent;
                        leftRotate(k);
                    }

                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = 0;
    }

    private void leftRotate(Node x){
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node x){
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    public void inOrder(Node root){
        if(root != TNULL){
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public Node containshelper(Node root  , int key){
        if(root == null){
            return null;
        }
        if(root.data == key){
            return root;
        }else if(root.data > key){
            return containshelper(root.left , key);
        }else{
            return containshelper(root.right , key);
        }
    }

    public boolean contains(int key){
        Node a = containshelper(root , key);
        if(a != null){
            return true;
        }else{
            return false;
        }
    }

    public int getRepeat(int data){
        Node a = containshelper(root , data);
        return a.repeat;
    }

    private int nearestHelper(int data){
        int closest = root.data;
        Node x = root;
        while(x != TNULL){
            if(x.data - data < closest){
                closest = x.data;
            }
            if (root.data > data){
                x = x.left;
            }else{
                x = x.right;
            }
        }
        return closest;
    }

    public int nearest(int data){
        if(contains(data)){
            return data;
        }
        int a = nearestHelper(data);
        return a;
    }

    public static void main(String[] args){
        RedBlackTree tree = new RedBlackTree();
//        You have access to these functions

//        1. put(data) -> Put data in the tree with Repetition value set as 1 it increases if you put duplicate value
//        2. put(data , repeatValue) -> Put data in the tree with Repetition value set as provided it increases if you duplicate value
//        3. getRepeat(data) -> Gives the repetition value of data provided
//        4. contains(data) -> return true if the value exits otherwise false
//        5. nearest(data) -> Return the nearest value of provided data
//        6. inOrder(root) -> prints the tree

        tree.put(7);
        tree.put(6);
        tree.put(5);
        tree.put(11);
        tree.put(3 , 9);
        tree.put(2);
        tree.put(1);
        tree.put(3);
//        System.out.println(tree.getRepeat(3));
        System.out.println(tree.contains(8));
        System.out.println(tree.nearest(10));
        tree.inOrder(tree.root);
    }
}
