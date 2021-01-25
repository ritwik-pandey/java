import java.awt.*;

public class KdTree {
    public class Node {
        Node left;
        Node right;
        int[] data;
        boolean y;
        public Node(int[] x , boolean a){
            data = new int[2];
            for(int i = 0 ; i < 2 ; ++i){
                data[i] = x[i];
            }
            y = a;
        }

    }

    public static class Point{
        int x;
        int y;
        public Point(int a , int b){
            x = a;
            y = b;
        }
    }

    Node root = null;
    int s = 0;

    public void insert(int[]x){
            root = insertHelper(x , root , 0);
            ++s;
    }

    private Node insertHelper(int[]x , Node root , int a){
        ++a;
        if(root == null){
            return new Node(x , a % 2 == 0);
        }
        int b = (a % 2 == 0)? 1 : 0;
        if(root.data[b] <= x[b]){
            root.right = insertHelper(x , root.right , a);
        }else{
            root.left = insertHelper(x , root.left , a);
        }
        return root;
    }

    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data[0] + "," + root.data[1]);
        inOrder(root.right);
    }

    public Node contains(Node root , Point a){
        if(root == null){
            return null;
        }
        if(root.data[0] == a.x && root.data[1] == a.y){
            return root;
        }
        if(a.y > root.data[1]){
            return contains(root.right , a);
        }else {
            return contains(root.left, a);
        }
    }

    public Node nearest(Node root , Point goal){
        return nearestHelper(root , goal , root);
    }

    private Node nearestHelper(Node n  , Point goal , Node best){
        Node goodSide;
        Node badSide;
        if(n == null){
            return best;
        }
        if(distance(goal , n) < distance(goal , best)){
            best = n;
        }

        if(n.y == true){
            if(goal.y > n.data[1]){
                goodSide = n.right;
                badSide = n.left;
            }else{
                goodSide = n.left;
                badSide = n.right;
            }
        }else{
            if(goal.x > n.data[0]){
                goodSide = n.right;
                badSide = n.left;
            }else{
                goodSide = n.left;
                badSide = n.right;
            }
        }

        best = nearestHelper(goodSide , goal , best);
        if(goal.y - n.data[1] > distance(goal , best)){
            best = nearestHelper(badSide , goal , best);
        }
        return best;
    }


    public Double distance(Point a , Node root){
        int c = root.data[0] < a.x? a.x - root.data[0] : root.data[0] - a.x;
        int d = a.y > root.data[1]? a.y - root.data[1] : root.data[1] - a.y;
        return Math.sqrt((c * c + d * d));
    }


    public static void main(String[] args){
        KdTree tree = new KdTree();
        int[] arr = new int[2];
        arr[0] = 2;
        arr[1] = 3;
        tree.insert(arr);
        arr[0] = 4;
        arr[1] = 2;
        tree.insert(arr);
        arr[0] = 4;
        arr[1] = 5;
        tree.insert(arr);
        arr[0] = 3;
        arr[1] = 3;
        tree.insert(arr);
        arr[0] = 1;
        arr[1] = 5;
        tree.insert(arr);
        arr[0] = 4;
        arr[1] = 4;
        tree.insert(arr);
        tree.inOrder(tree.root);
        Node c = tree.nearest(tree.root , new Point(0 , 7));
        System.out.println(c.data[0] + " " + c.data[1]);
        System.out.println(tree.contains(tree.root , new Point(28 , 3)));
    }
}
