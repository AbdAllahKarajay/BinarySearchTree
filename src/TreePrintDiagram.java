import java.util.LinkedList;


public class TreePrintDiagram {
    static int[][][] treeLevels;
    static LinkedList<Integer> rights = new LinkedList<>();
    public static int traverseTree(BST.Node node, int level){
        if(node.left == null && node.right == null){
            return (node.data);
        }
        int rightIndex = 0;

        //calculate right index
        for (int r:rights) {
            int levelDiff = level - r;
            rightIndex += Math.pow(2,levelDiff-1);
        }

        if(treeLevels[level] == null){
            treeLevels[level] = new int[(int) Math.pow(2,level)][2];
        }
        if(node.left != null){
            int n = traverseTree(node.left, level+1);
            treeLevels[level][rightIndex][0] = n;
        }
        if(node.right != null){
            rights.add(level);
            treeLevels[level][rightIndex][1] = traverseTree(node.right, level+1);
        }
        return node.data;
    }

    static private int getHeight(BST.Node node) {
        if (node == null) {return -1;}
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public  static void print(BST.Node root){
        rights = new LinkedList<>();
        int levels = getHeight(root);
        treeLevels = new int[levels][][];
        traverseTree(root,0);

        StringBuilder line = new StringBuilder();
        int currentSpace = (int) Math.pow(2, levels+1);
        addSpace(line, levels, currentSpace," ");
        line.append(root.data);
        System.out.println(line);
        for (int[][] treeLevel : treeLevels) {
            line = new StringBuilder();
            currentSpace = currentSpace / 2;
            addSpace(line, levels, currentSpace, " ");
            for (int[] ints : treeLevel) {
                line.append(ints[0] != 0 ? ints[0] : " ");
                addSpace(line, levels, (currentSpace * 2), "-");
                line.append(ints[1] != 0 ? ints[1] : " ");
                addSpace(line, levels, (currentSpace * 2), " ");
            }
            System.out.println(line);
        }
    }
    private static void addSpace(StringBuilder stringBuilder,int height, int space, String repeated){
        stringBuilder.append(repeated.repeat(2 * space-1));
    }
}