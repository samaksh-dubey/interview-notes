package com.sam.dsa.greedy;

import java.util.*;

public class HuffmanCoding {

    static class Node {
        Character ch;
        int fq;
        Node left, right;

        private Node(Character ch, int fq, Node left, Node right) {
            this.ch = ch;
            this.fq = fq;
            this.left = left;
            this.right = right;
        }

        static Node of(Character ch, Integer fq, Node left, Node right) {
            return new Node(ch, fq, left, right);
        }
    }

    static class Huffman {

        private final Node huffmanTree;
        private final Map<Character, String> huffmanCode;
        private final String encodedText;

        public Huffman(String text) {
            this.huffmanTree = buildTree(text);
            this.huffmanCode = new HashMap<>();
            buildCodes(huffmanTree, "");
            this.encodedText = encodeText(text);
        }

        private Node buildTree(String s) {
            Map<Character, Integer> fqMap = new HashMap<>();
            for (Character ch: s.toCharArray()) {
                fqMap.put(ch, fqMap.getOrDefault(ch, 0) + 1);
            }

            Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.fq));

            for(Map.Entry<Character, Integer> entry: fqMap.entrySet()) {
                queue.add(Node.of(entry.getKey(), entry.getValue(), null, null));
            }

            while(queue.size() != 1) {
                Node left = queue.poll();
                Node right = queue.poll();
                queue.add(Node.of(null, (left != null ? left.fq : 0) + (right != null ? right.fq : 0), left, right));
            }

            return queue.poll();
        }

        private void buildCodes(Node node, String code) {
            if (node == null)
                return;

            if (node.left == null && node.right == null)
                this.huffmanCode.put(node.ch, code.isEmpty() ? "1" : code);

            buildCodes(node.left, code + "0");
            buildCodes(node.right, code + "1");
        }

        private String encodeText(String text) {
            StringBuilder sb = new StringBuilder();
            for(Character ch: text.toCharArray())
                sb.append(huffmanCode.get(ch));
            return sb.toString();
        }

        private int decodeText(Node node, int index, StringBuilder sb) {
            if (node == null)
                return index;

            if (node.left == null && node.right == null) {
                sb.append(node.ch);
                return index;
            }

            index++;
            index = encodedText.charAt(index) == '0' ? decodeText(node.left, index, sb) : decodeText(node.right, index, sb);
            return index;
        }

        public void printHuffmanCode() {
            System.out.println("Huffman codes are :");
            for (Map.Entry<Character, String> entry: this.huffmanCode.entrySet())
                System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        public String getEncodedText() {
            return this.encodedText;
        }

        public String getDecodedText() {
            StringBuilder sb = new StringBuilder();
            if (this.huffmanTree.left == null && this.huffmanTree.right == null) {
                int freq = this.encodedText.length();
                while (freq-- > 0) {
                    sb.append(this.huffmanTree.ch);
                }
            } else {
                int index = -1;
                while(index < encodedText.length() - 1)
                    index = decodeText(this.huffmanTree, index, sb);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Huffman huffman = new Huffman("Huffman coding is a data compression algorithm.");
        huffman.printHuffmanCode();
        System.out.println("\nEncoded text is : ");
        System.out.println(huffman.getEncodedText());
        System.out.println("\nDecoded text is : ");
        System.out.println(huffman.getDecodedText());
    }
}
