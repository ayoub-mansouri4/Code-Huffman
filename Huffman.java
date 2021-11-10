// node class is the basic structure
// of each node present in the Huffman - tree.
class HuffmanNode {

    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;
}
class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y)
    {

        return x.data - y.data;
    }
}
class public Huffman{

public static void printCode(HuffmanNode root, String s)
        {


        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
        System.out.println(root.c + ":" + s);
        return;
        }


        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
        }

    public static void main(String[]args){ 
        int n = 6;
        
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        
        int[] charfreq = { 5, 9, 12, 13, 16, 45 } ; 
        
        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyComparator());

    }
}
