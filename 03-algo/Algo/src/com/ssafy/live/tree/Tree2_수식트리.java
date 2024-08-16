package com.ssafy.live.tree;

public class Tree2_수식트리 {
	static char[] tree = { 0, '+', 'x', '-', '1', '2', '3', '4' };

	public static void main(String[] args) {
		inorder(1);
		System.out.println();
		postorder(1);
		System.out.println();
		preorder(1);
	}

	// L->V->R
	static void inorder(int root) {
//		// 기저조건1 : 인덱스가 배열 범위를 벗어남
//		if (root >= tree.length) {
//			return;
//		}
//		// 기저조건2 : 리프노드인 경우, 리프노드는 항상 피연산자
//		if ('0' <= tree[root] && tree[root] <= '9') {
//			System.out.print(tree[root]);
//			return;
//		}
//
//		inorder(root * 2);
//		System.out.print(tree[root]);
//		inorder(root * 2 + 1);

		if (root * 2 < tree.length)
			inorder(root * 2);

		System.out.print(tree[root]);

		if (root * 2 + 1 < tree.length)
			inorder(root * 2 + 1);
	}

	// L->R->V
	static void postorder(int root) {
		if (root * 2 < tree.length)
			postorder(root * 2);

		if (root * 2 + 1 < tree.length)
			postorder(root * 2 + 1);

		System.out.print(tree[root]);
	}

	// V->L->R
	static void preorder(int root) {
		System.out.print(tree[root]);

		if (root * 2 < tree.length)
			preorder(root * 2);

		if (root * 2 + 1 < tree.length)
			preorder(root * 2 + 1);

	}
}
