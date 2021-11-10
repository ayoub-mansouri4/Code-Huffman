import java.util.*;

// node class is the basic structure
// of each node present in the Huffman - tree.
class HuffmanNode {
    int data;//nbr d'occurences de c
    char c;//charactere
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

public class Huffman{

    // c'est une fonction recursive qui parcour l'arbre et donne le codage de chaque charactere
    public static void printCode(HuffmanNode root, String s){
        // si root.left et root.right sont null
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    //fonction qui trie les valeurs de Hashmap
    public static HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> hm)
    {
        List<Map.Entry<Character, Integer> > list = new LinkedList<Map.Entry<Character, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    //fonction qui donne le nombre d'occurences de chaque charactere stocke dans un dictionnaire (Hashmap)
    private static HashMap<Character, Integer> CountChar(String str,int n){
        Character ch;
        Integer weight;
        HashMap<Character, Integer> CountChar=new HashMap<Character,Integer>();
        for (int i=0; i<n; i++){
        ch = str.charAt(i);
        if (CountChar.containsKey(ch) == false)
        weight = 1;
        else
        weight = CountChar.get(ch) + 1;
        CountChar.put(ch, weight);
        }
        return CountChar;
    }
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        System.out.println("donner une chaîne de caracteres à compresser en utilisant l'algorithme de Huffman:");
        String str=s.nextLine();
        // number of characters.
        int n = str.length();
        HashMap<Character, Integer> HashOfStr=CountChar(str,n);
        //C'est une map qui liee a chaque charactere son nombre d'occurences dans str
        HashMap<Character, Integer> HashOfStrSorted=sortByValue(HashOfStr);

        int lenOFHashMap=HashOfStr.size();
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
