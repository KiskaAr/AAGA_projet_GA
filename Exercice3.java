package tme2;

import java.util.ArrayList;
import java.util.Random;

public class Exercice3 {
	static Random r = new Random();

	public static ArrayList<Node> remyTree(int size) {

		ArrayList<Node> tree = new ArrayList<Node>();
		
		// Premier Noeud
		if (size > 0) {
			Node n1 = new Node(-1, -1, -1, 1);
			tree.add(n1);
		}
		
		int etiq = 2;
		
		for (int i = 1; i < size; i++) {
			int i_current_node = (r.nextInt(tree.size()));

			int p_f = r.nextInt(2);

			Node new_Pere;
			Node fils;
			// gauche
			if (p_f == 0) {

				new_Pere = new Node(tree.get(i_current_node).getPere(), i_current_node, -1, -1);
				tree.add(new_Pere);
				fils = new Node(tree.indexOf(new_Pere), -1, -1, etiq++);
				tree.add(fils);
				new_Pere.setFd(tree.indexOf(fils));
				tree.get(i_current_node).setPere(tree.indexOf(new_Pere));

			} else { // droite

				new_Pere = new Node(tree.get(i_current_node).getPere(), -1, i_current_node, -1);
				tree.add(new_Pere);
				fils = new Node(tree.indexOf(new_Pere), -1, -1, etiq++);
				tree.add(fils);
				new_Pere.setFg(tree.indexOf(fils));
				tree.get(i_current_node).setPere(tree.indexOf(new_Pere));
			}

		}
		return tree;
	}

	private static class  Node {
		private int pere;
		private int fg;
		private int fd;
		private int val;

		public Node(int pere, int fg, int fd, int val) {
			super();
			this.pere = pere;
			this.fg = fg;
			this.fd = fd;
			this.val = val;
		}

		public int getPere() {
			return pere;
		}

		public void setPere(int pere) {
			this.pere = pere;
		}

		public int getFg() {
			return fg;
		}

		public void setFg(int fg) {
			this.fg = fg;
		}

		public int getFd() {
			return fd;
		}

		public void setFd(int fd) {
			this.fd = fd;
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}
		
		@Override
		public String toString() {
			return "Node [pere=" + pere + ", fg=" + fg + ", fd=" + fd + ", val=" + val + "]\n";
		}
	}
	
	public static void main(String[] args) {
		
		ArrayList<Node> tree = remyTree(10000);
		System.out.println(tree.toString());
		
	}

}
