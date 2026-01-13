import java.util.Stack;

public class BST_3 {
    class Node{
        Node left,right;
        int key;

        public Node(int key) {
            this.left = null;
            this.right = null;
            this.key = key;
        }
    }
    Node root;

    public BST_3() {
        this.root = null;
    }

    public Node insert(Node root, int key){
        Node newNode = new Node(key);
        if(root == null){
            return newNode;
        }
        Node current = root;
        Node parent = null;
        while(current != null){
            parent = current;
            if(key < current.key){
                current = current.left;
            } else if (key > current.key) {
                current = current.right;
            } else {
                System.out.println("duplicate");
                return root;
            }
        }
        if(key < parent.key){
            parent.left = newNode;
        }
        if (key > parent.key) {
            parent.right = newNode;
        }
        return root;
    }

    public Node insertrec(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }
            if(key < root.key){
                root.left = insertrec(root.left,key);
            } else if (key > root.key) {
                root.right = insertrec(root.right,key);
            }
        return root;
    }

    public void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }

    public boolean valid(Node root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.key <= min || root.key >= max){
            return false;
        }
        return valid(root.left,min,root.key) && valid(root.right,root.key,max);
    }

    public void printKDistance(Node root, int k){
        if(root == null){
            return;
        }
        if(k == 0){
            System.out.print(root.key+" ");
            return;
        }
        printKDistance(root.left,k-1);
        printKDistance(root.right,k-1);
    }

    public boolean equal(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return equal(root1.left,root2.left) && equal(root1.right,root2.right);
    }

    public void preorder(Node root){
        if(root != null){
            System.out.print(root.key+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key+" ");
        }
    }

    public Node search(Node root, int key){
        if(root == null || root.key == key){
            return root;
        }
        if(root.key > key){
           return search(root.left,key);
        }
       return search(root.right,key);
    }

    public Node recursivesearch(Node root, int key){
        Node current = root;
        while(current != null){
            if(current.key == key){
                return current;
            } else if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public int max(Node root){
        if(root == null){
            return -1;
        }
        Node curr = root;
        while (curr.right != null){
            curr = curr.right;
        }
        return curr.key;
    }

    public int min(Node root){
        if(root == null){
            return -1;
        }
        Node curr = root;
        while(curr.left != null){
            curr = curr.left;
        }
        return curr.key;
    }

    public int recursivemax(Node root){
        if(root == null){
            return -1;
        }
        if(root.right == null){
            return root.key;
        }
        return recursivemax(root.right);
    }

    public int recursivemin(Node root){
        if(root == null) {
            return -1;
        }
        if(root.left == null){
                return root.key;
            }
            return recursivemin(root.left);
        }


    public void morrisinorder(Node root){
        Node current = root;
        while(current != null){
            if(current.left == null){
                System.out.print(current.key+" ");
                current = current.right;
            } else{
                Node predecessor = current.left;
                while(predecessor.right != null && predecessor.right != current){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                } else{
                    predecessor.right = null;
                    System.out.print(current.key+" ");
                    current = current.right;
                }
            }
        }
    }

    public void morrispreorder(Node root){
        Node current = root;
        while(current != null){
            if(current.left == null){
                System.out.print(current.key+" ");
                current = current.right;
            } else {
                Node predecessor = current.left;
                while(predecessor.right != null && predecessor.right != current){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = current;
                    System.out.print(current.key+" ");
                    current = current.left;
                } else{
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }

    public void stackpostorder(Node root){
        if(root == null){
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);
        while(!s1.isEmpty()){
            Node current = s1.pop();
            s2.push(current);
            if(current.left != null){
                s1.push(current.left);
            }
            if(current.right != null){
                s1.push(current.right);
            }
        }
        while(!s2.isEmpty()){
            System.out.print(s2.pop().key+" ");
        }

    }

    public static void main(String[] args) {
        BST_3 t = new BST_3();
        t.root = t.insertrec(t.root, 50);
        t.root = t.insertrec(t.root, 30);
        t.root = t.insertrec(t.root, 20);
        t.root = t.insertrec(t.root, 40);
        t.root = t.insertrec(t.root, 70);
        t.root = t.insertrec(t.root, 60);
        t.root = t.insertrec(t.root, 80);
        // Print inorder traversal of the BST
        t.inorder(t.root);
        System.out.println();
        t.morrisinorder(t.root);

        //   System.out.println(t.search(t.root,20).key);
        System.out.println(t.search(t.root,20));
        System.out.println(t.min(t.root));
        System.out.println(t.recursivemin(t.root));
        System.out.println(t.max(t.root));
        System.out.println(t.recursivemax(t.root));
        System.out.println("inorder");
        t.inorder(t.root);
        System.out.println();
        System.out.println("preorder");
        t.preorder(t.root);
        System.out.println();
        System.out.println("postorder");
        t.postorder(t.root);
        BST_3 t2 = new BST_3();
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

        BST_3 r = new BST_3();
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
        System.out.println(r.recursivesearch(r.root,40));
        r.morrispreorder(r.root);
        System.out.println();
        r.stackpostorder(r.root);
        System.out.println();
        System.out.println(r.recursivemax(r.root));
        System.out.println(r.recursivemin(r.root));


    }
}
