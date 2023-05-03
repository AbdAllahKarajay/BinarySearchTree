public class Main {
    public static void main(String[] args) {
        BST.BinaryTree tree = new BST.BinaryTree();
        int[] pre = new int[]{50,30,20,10,25,40,45,70,60,80};

        BST.Node root = tree.constructTreeUtil(pre, tree.index,pre[0],Integer.MIN_VALUE,Integer.MAX_VALUE, pre.length);
        TreePrintDiagram.print(root);
    }
}