public class BST {
    private int size; //Size of the tree

//    Class to create a new tree node
    private class Node {
        Node left;
        Node right;
        int value;
        public Node(int a){
            value = a;
        }
    }

//    Inserts a new node

    private Node insertValue(int a , Node root){
        if(root == null){
            return new Node(a);
        }else if(root.value > a){
            root.left = insertValue(a , root.left);
        }else if(root.value < a) {
            root.right = insertValue(a, root.right);
        }
        return root;
    }


    public Node insert(Node root , int value){
        ++size;
        return insertValue(value , root);
    }

//    Find a node according to the value

    public Node find(Node rootCopy , int key){
        if(rootCopy == null){
            return null;
        }else if(rootCopy.value == key){
            return rootCopy;
        }else if(key < rootCopy.value){
            return find(rootCopy.left , key);
        }else{
            return find(rootCopy.right , key);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        Node root = null;
        root = tree.insert(root , 5);
        root = tree.insert(root , 6);
        root = tree.insert(root , 4);
        System.out.println(tree.find(root , 5));
    }
}
