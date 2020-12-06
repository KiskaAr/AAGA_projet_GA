package aaga;

import java.util.ArrayList;
import java.util.Random;

class Noeud {
	public Noeud fils_gauche;
	public Noeud fils_droite;

	public Noeud(Noeud fg, Noeud fd) {
		this.fils_gauche = fg;
		this.fils_droite = fd;
	}
}

public class ABR {

	public Noeud racine;

	public ABR(int n) {
		generate(n);
	}

	private void generate(int n) {

		ArrayList<Noeud> leafs = new ArrayList<Noeud>();
		Random rand = new Random();

		racine = new Noeud(null, null);
		leafs.add(racine);

		for (int i = 1; i < n; i++) {
			// Choose a leaf uniformly from leafs set
			int r = rand.nextInt(leafs.size());
			Noeud leaf = leafs.get(r);

			Noeud node = new Noeud(null, null);

			if (leaf.fils_gauche == null & leaf.fils_droite != null) {
				leaf.fils_gauche = node;
				leafs.remove(r);
			} else if (leaf.fils_gauche != null & leaf.fils_droite == null) {
				leaf.fils_droite = node;
				leafs.remove(r);
			} else {
				boolean b = rand.nextBoolean();
				if (b) {
					leaf.fils_gauche = node;
				} else {
					leaf.fils_droite = node;
				}
			}
			leafs.add(node);
		}

	}

	public int height(Noeud tree) {

		if (tree == null) {
			return 0;
		}
		return 1 + Math.max(height(tree.fils_gauche), height(tree.fils_droite));
	}
	
	public int min_height(Noeud tree) {

		if (tree == null) {
			return 0;
		}
		return 1 + Math.min(height(tree.fils_gauche), height(tree.fils_droite));
	}
	
	public void treeToString(Noeud tree, String tab) {

		if (tree != null) {
			System.out.println(tab + "#");
			treeToString(tree.fils_gauche, tab + " ");
			treeToString(tree.fils_droite, tab + " ");
		}
	}

}
