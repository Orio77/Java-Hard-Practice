package algorithms.exercise9_greedyAlgorithms.scenario2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
// AI Copied
public class Huffman {
    
    public static void encode(Node root, String str, Map<Character, String> huffmanCode) {
        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            huffmanCode.put(root.getCh(), str.length() > 0 ? str : "1");
        }

        encode(root.getLeft(), str + '0', huffmanCode);
        encode(root.getRight(), str + '1', huffmanCode);
    }

    public static boolean isLeaf(Node node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    public static void buildHuffmanTree(String text) {

        if (text == null || text.length() == 0) {
            return;
        }

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> pQueue = new PriorityQueue<>((l, r) -> l.getFreq() - r.getFreq());

        for (var entry : freq.entrySet()) {
            pQueue.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (pQueue.size() != 1) {
            Node left = pQueue.poll();
            Node right = pQueue.poll();

            int sum = left.getFreq() + right.getFreq();
            pQueue.add(new Node('\0', sum, left, right));
        }

        Node root = pQueue.peek();
        Map<Character, String> huffmanCOde = new HashMap<>();
        encode(root, "", huffmanCOde);

        System.out.println("Huffman Codes are: " + huffmanCOde);
        System.out.println("Original string was: " + text);

        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(huffmanCOde.get(c));
        }
        System.out.println("Encoded string is: " + sb);
    }

    public static void main(String[] args) {
        String text = "hello world";
        buildHuffmanTree(text);
    }


}
