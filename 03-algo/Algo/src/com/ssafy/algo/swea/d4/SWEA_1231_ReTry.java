package com.ssafy.algo.swea.d4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SWEA_1231_ReTry {

	static int i;

	static class Node {
		char value;
		Node left;
		Node right;

		public Node(char value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	static class Tree {
		Node root;
		Map<Integer, Node> nodeMap;

		public Tree() {
			nodeMap = new HashMap<>();
		}

		public void addNode(int number, char value, int left, int right) {
			Node newNode = nodeMap.getOrDefault(number, new Node(value));
			newNode.value = value;

			if (left != -1) {
				Node leftNode = nodeMap.getOrDefault(left, new Node(' '));
				newNode.left = leftNode;
				nodeMap.put(left, leftNode);
			}

			if (right != -1) {
				Node rightNode = nodeMap.getOrDefault(right, new Node(' '));
				newNode.right = rightNode;
				nodeMap.put(right, rightNode);
			}

			nodeMap.put(number, newNode);

			if (number == 1) {
				root = newNode;
			}
		}

		public void inorderTraversal(Node node) {
			if (node != null) {
				inorderTraversal(node.left);
				System.out.print(node.value);
				inorderTraversal(node.right);
			}
		}

		public void printInorder() {
			System.out.print("#" + i + " ");
			inorderTraversal(root);
			System.out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1231.txt"));
		Scanner sc = new Scanner(System.in);

		for (i = 1; i <= 10; i++) {
			int N = sc.nextInt();
			sc.nextLine();

			Tree tree = new Tree();

			for (int j = 0; j < N; j++) {
				String line = sc.nextLine();
				String[] parts = line.split(" ");

				int number = Integer.parseInt(parts[0]);
				char value = parts[1].charAt(0);
				int left = parts.length > 2 ? Integer.parseInt(parts[2]) : -1;
				int right = parts.length > 3 ? Integer.parseInt(parts[3]) : -1;

				tree.addNode(number, value, left, right);
			}

			tree.printInorder();
		}
		sc.close();
	}
}
