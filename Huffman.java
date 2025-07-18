import java.util.Comparator;  
import java.util.HashMap;  
import java.util.Map;  
import java.util.PriorityQueue;  
import java.util.*;
public class Huffman {
	
	public static void createHuffmanTree(String text) {
        if (text == null || text.length() == 0) {
            return;
        }

        Map<Character, Integer> freq = new HashMap<>();

        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        System.out.println("Character\tFrequency\tHuffman Code");
        System.out.println("---------------------------------------------");

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.freq));

        for (var entry : freq.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (pq.size() != 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            int sum = left.freq + right.freq;
            pq.add(new Node(null, sum, left, right));
        }

        Node root = pq.peek();
        Map<Character, String> huffmanCode = new HashMap<>();
        encodeData(root, "", huffmanCode);

        for (var entry : huffmanCode.entrySet()) {
            System.out.printf("%-10s\t%-10d\t%s\n", entry.getKey(), freq.get(entry.getKey()), entry.getValue());
        }

        System.out.println("---------------------------------------------");
        System.out.println("Initial data: " + text);

        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(huffmanCode.get(c));
        }
        System.out.println();
        System.out.println("Encoded data: " + sb);
        System.out.println();
        System.out.print("Decoded data: ");

        if (isLeaf(root)) {
            while (root.freq-- > 0) {
                System.out.print(root.ch);
            }
        } else {
            int index = -1;
            while (index < sb.length() - 1) {
                index = decodeData(root, index, sb);
            }
        }
    }

    public static void encodeData(Node root, String str, Map<Character, String> huffmanCode) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            huffmanCode.put(root.ch, str.length() > 0 ? str : "1");
        }
        encodeData(root.left, str + '0', huffmanCode);
        encodeData(root.right, str + '1', huffmanCode);
    }

    public static int decodeData(Node root, int index, StringBuilder sb) {
        if (root == null) {
            return index;
        }
        if (isLeaf(root)) {
            System.out.print(root.ch);
            return index;
        }
        index++;
        root = (sb.charAt(index) == '0') ? root.left : root.right;
        index = decodeData(root, index, sb);
        return index;
    }

    public static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    public static void main(String args[]) {
        System.out.println("Enter the string to be decoded: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        createHuffmanTree(text);
    }
}
