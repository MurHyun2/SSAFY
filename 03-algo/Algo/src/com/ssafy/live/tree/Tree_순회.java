package com.ssafy.live.tree;

public class Tree_순회 {
	static char[] tree = { 0, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 0, 0, 'H', 'I' };

	// 매개변수로 트리의 루트 index 받기
	// 전위 순회 V->L->R
	static public void preoreder(int root) {
		if (root >= tree.length || tree[root] == 0)
			return;
		System.out.print(tree[root] + " -> ");
		preoreder(root * 2);
		preoreder(root * 2 + 1);
	}

	// 중위 순회 L->V->R
	static public void inoreder(int root) {
		if (root >= tree.length || tree[root] == 0)
			return;
		inoreder(root * 2);
		System.out.print(tree[root] + " -> ");
		inoreder(root * 2 + 1);
	}

	// 후위 순회 L->R->V
	static public void postoreder(int root) {
		if (root >= tree.length || tree[root] == 0)
			return;
		postoreder(root * 2);
		postoreder(root * 2 + 1);
		System.out.print(tree[root] + " -> ");
	}

	public static void main(String[] args) {
		System.out.println("전위 순회");
		preoreder(1);
		System.out.println();

		System.out.println("중위 순회");
		inoreder(1);
		System.out.println();

		System.out.println("후위 순회");
		postoreder(1);
	}
}
