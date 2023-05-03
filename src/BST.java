import static java.lang.Math.pow;

public class BST {

    static class Node {

        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }

        private Node() {
        }
    }

    static class Index {

        int index = 0;
    }

    static class BinaryTree {

        Index index = new Index();

        public Node constructTreeUtil(int[] pre, Index preIndex, int key, int min, int max, int size) {
// Base case
            if (preIndex.index >= size) {
                return null;
            }
            Node root = null;

            if (key > min && key < max) {
                preIndex.index++;
                root = new Node(key);
                if (preIndex.index < size) {
                    root.left = constructTreeUtil(pre, preIndex, pre[preIndex.index], min, key, size);
                }
                if (preIndex.index < size) {
                    root.right = constructTreeUtil(pre, preIndex, pre[preIndex.index], key, max, size
                    );
                }
            }
            return root;
        }

        void printInorder(Node node) {
            if (node == null) {
                return;
            }
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }

    }

    static int TotalNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = TotalNodes(root.left);
        int rh = TotalNodes(root.right);

        if (lh == rh) {
            return (int) (pow(2, lh + 1) - 1);
        }
        return 1 + lh + rh;
    }

    static Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.data) {
            root.left = insertRec(root.left, key);
        } else if (key > root.data) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }
    static boolean there(Node root,int key)
    {
          if (root == null ) {

                return false;
            }
           if (root.data==key) {

                return true;
            }
     boolean x ;
            if (key < root.data) {
               x = there(root.left, key);
                return x == true;
            }
            else {
                return there(root.right, key);
            }

    }
    static Node deleteRec(Node root , int key)
    {
    if (root == null)
        return root ;
    if (key < root.data)
    root.left = deleteRec(root.left, key);
    else if (key > root.data)
    root.right = deleteRec(root.right, key);
    else {
    // node with only one child or no child
    if ( root.left == null)
        return root.right ;
    else if ( root.right == null)
        return root.left ;

    root.data = minValue(root.right);
    // Delete the inorder successor
    root.right = deleteRec(root.right, root.data);
    }
    return root ;
    }
    static int minValue(Node root)
    {

            if(root == null)
                return Integer.MAX_VALUE ;
        while(root.left!=null)
        {
            root=root.left;

        }
    return root.data;
    }

    static int maxValue(Node root)
    {

        if(root == null)
            return Integer.MIN_VALUE ;
        while(root.right!=null)
        {
            root=root.right;

        }

    return root.data;
    }

    static boolean isBST(Node Node)
    {
        if (Node == null) {
          return true;
        }


        if (maxValue(Node.left) > Node.data) {
          return false;
        }


        if (minValue(Node.right) < Node.data) {
          return false;
        }

        return isBST(Node.left) && isBST(Node.right);
    }
    public static void iterativeinsert(int key,Node root) {
        Node newNode = new Node(key);
        if (root == null) {
            root = new Node(key);
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (key < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public static  Node iterativesearch(int key, Node root) {
        Node current = root;
        while (current != null) {
            if (current.data == key) {
                return current;
            } else if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    static int COUNT = 10;
}
