public class BST {

    private class Node {
        Node left;
        Node right;
        int value;
        public Node(int a){
            value = a;
            left = right = null;
        }
    }

    public BST(){
        root = null;
    }
    Node root;

//    Inserts a new node

    private Node insertValue(Node root , int a){
        if(root == null){
            root = new Node(a);
            return root;
        }else if(root.value > a){
            root.left = insertValue(root.left , a);
        }else if(root.value < a) {
            root.right = insertValue(root.right, a);
        }
            return root;

    }


    public void insert(int value){
        root = insertValue(root , value);
    }

//    Find a node according to the value

    public Node find(int key , Node root){
        if(root == null){
            return null;
        }else if(root.value == key){
            return root;
        }else if(key < root.value){
            return find(key , root.left);
        }else{
            return find(key , root.right);
        }
    }

    public Node findMinimum(Node root){
        if(root.left == null){
            return root;
        }else{
            return findMinimum(root.left);
        }
    }

    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    public void deleteNode(int key){
        root = delete(root , key);
    }

    private Node delete(Node root , int k){
        if(root == null){
            return root;
        }

        if(k < root.value){
            root.left = delete(root.left , k);
        }else if(root.value < k){
            root.right = delete(root.right , k);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            root.value = findMinimum(root.right).value;
            root.right = delete(root.right , root.value);
        }
        return root;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(5);
        tree.insert(6);
        tree.insert(4);
        tree.insert(7);
        tree.insert(3);
//        System.out.println(tree.findMinimum(tree.root).value);
        tree.deleteNode(5);
        tree.inOrder(tree.root);

//        System.out.println(tree.find(root , 5));
    }
}

