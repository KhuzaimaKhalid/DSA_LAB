import java.util.LinkedList;
import java.util.Queue;

public class BST_2 {
   class Node{
        Node left,right;
        int key;

        public Node( int key) {
            this.left = null;
            this.right = null;
            this.key = key;
        }
    }
    Node root;

    public BST_2() {
        this.root = null;
    }

    Node insertrec(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }
        if(key < root.key){
            root.left = insertrec(root.left,key);
        } else if (key > root.key) {
            root.right =  insertrec(root.right,key);
        }
        return root;
    }

    public  Node insert(Node root, int key){
        Node newNode = new Node(key);
        if(root == null){
            return newNode;
        }
        Node current = root;
        Node parent = null;
        while (current != null){
            parent = current;
            if(key < current.key){
                current = current.left;
            } else if (key > current.key) {
                current = current.right;
            } else{
                System.out.println("duplicate node");
                return root;
            }
        }
        if(key < parent.key){
            parent.left = newNode;
        }
        if(key > parent.key){
            parent.right = newNode;
        }
        return root;
    }

    Node search(Node root, int key){
        if(root == null || root.key == key){
            return root;
        }
        if(root.key > key){
            return search(root.left,key);
        }
        return search(root.right,key);
    }

    void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root){
        if(root != null){
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }

    int max(Node root){
        if(root == null){
            return -1;
        }
        Node curr = root;
        while(curr.right != null){
            curr = curr.right;
        }
        return curr.key;
    }

    int min(Node root){
        if(root == null){
            return -1;
        }
        Node curr = root;
        while(curr.left != null){
            curr = curr.left;
        }
        return curr.key;
    }
    boolean equal(Node root1, Node root2){
        if((root1 == null && root2 == null)){
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        return equal(root1.left, root2.left) && equal(root1.right, root2.right);
    }
    boolean valid(Node root, int min, int max){
        if(root == null){
            return true;
        }
        if (root.key <= min || root.key >= max) {
            return false;
        }
        return valid(root.left, min, root.key) && valid(root.right, root.key, max);
    }
    void printKDistance(Node root, int k) {

        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.print(root.key + " ");
            return;
        }
        printKDistance(root.left, k - 1);
        printKDistance(root.right, k - 1);
    }

    public void BSFiterative(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.print(curr.key+" ");
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BST_2 t = new BST_2();
        t.root = t.insertrec(t.root, 50);
        t.root = t.insertrec(t.root, 30);
        t.root = t.insertrec(t.root, 20);
        t.root = t.insertrec(t.root, 40);
        t.root = t.insertrec(t.root, 70);
        t.root = t.insertrec(t.root, 60);
        t.root = t.insertrec(t.root, 80);
        // Print inorder traversal of the BST
        t.inorder(t.root);
        //   System.out.println(t.search(t.root,20).key);
        System.out.println(t.search(t.root,20));
        System.out.println(t.min(t.root));
        System.out.println(t.max(t.root));
        System.out.println("inorder");
        t.inorder(t.root);
        System.out.println();
        System.out.println("preorder");
        t.preorder(t.root);
        System.out.println();
        System.out.println("postorder");
        t.postorder(t.root);
        BST_2 t2 = new BST_2();
        t2.root = t2.insertrec(t2.root, 50);
        t2.root = t2.insertrec(t2.root, 30);
        t2.root = t2.insertrec(t2.root, 70);

        if (t.equal(t.root, t2.root)) {
            System.out.println("Trees are equal");
        } else {
            System.out.println("Trees are NOT equal");
        }

        boolean isValid = t.valid(t.root, Integer.MIN_VALUE, Integer.MAX_VALUE);

        if (isValid) {
            System.out.println("Tree is a valid BST");
        } else {
            System.out.println("Tree is NOT a valid BST");
        }
        System.out.println("Nodes at distance 2:");
        t.printKDistance(t.root, 2);

        BST_2 r = new BST_2();
        r.root = r.insert(r.root, 50);
        r.root = r.insert(r.root, 30);
        r.root = r.insert(r.root, 70);
        r.root = r.insert(r.root, 20);
        r.root = r.insert(r.root, 40);
        r.root = r.insert(r.root, 60);
        r.root = r.insert(r.root, 80);
        r.root = r.insert(r.root, 30); // duplicate → prints "DUPLICATE NODE"

        System.out.print("Inorder traversal: ");
        r.inorder(r.root); // expected: 20 30 40 50 60 70 80

    }


}


