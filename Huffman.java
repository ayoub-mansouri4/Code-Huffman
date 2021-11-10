import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

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

    }
}
