import java.util.*;

// node class is the basic structure
// of each node present in the Huffman - tree.
class HuffmanNode {

    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;
}
//le comparateur aide à comparer le Huffman Node
class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y)
    {

        return x.data - y.data;
    }
}
class public Huffman{
// c'est une fonction recursive
    public static void printCode(HuffmanNode root, String s){
        // si root.left et root.right sont null

        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }


        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        String str=s.nextLine();
        //System.out.println(str);
        // number of characters.
        int n = str.length();
        HashMap<Character, Integer> HashOfStr=CountChar(str,n);
        HashMap<Character, Integer> HashOfStrSorted=sortByValue(HashOfStr);
        int nn=HashOfStr.size();
        //char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        //int[] charfreq = { 5, 9, 12, 13, 16, 45 };

        // creating a priority queue q.
        // makes a min-priority queue(min-heap).
        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyComparator());

        for (Character ch : HashOfStrSorted.keySet()) {

        // creating a Huffman node object
        // and add it to the priority queue.
        HuffmanNode hn = new HuffmanNode();

        hn.c = ch;
        hn.data = HashOfStrSorted.get(ch);
        System.out.println(ch+" "+ hn.data);
        hn.left = null;
        hn.right = null;

        // add functions adds
        // the huffman node to the queue.
        q.add(hn);
        }

        // create a root node
        HuffmanNode root = null;

        // Here we will extract the two minimum value
        // from the heap each time until
        // its size reduces to 1, extract until
        // all the nodes are extracted.
        while (q.size() > 1) {

        // first min extract.
        HuffmanNode x = q.peek();
        q.poll();

        // second min extract.
        HuffmanNode y = q.peek();
        q.poll();

        // new node f which is equal
        HuffmanNode f = new HuffmanNode();

        // to the sum of the frequency of the two nodes
        // assigning values to the f node.
        f.data = x.data + y.data;
        f.c = '-';

        // first extracted node as left child.
        f.left = x;
        // second extracted node as the right child.
        f.right = y;
        root = f;
        q.add(f);
        }
        printCode(root, "");
        }
}
