package tp00;

import java.util.Arrays;
import java.util.List;

public class TpTri {
	/**
	 * Indique si le vecteur est tri� de mani�re croissante
	 * Un vecteur de taille 0 sera consid�r� comme tri�
	 * @param v 
	 * @return true ou false en fct que le vecteur est tri�
	 */
	public static boolean estTrie(int[] v) {
		int i = v.length - 2;
		while (i >= 0 && v[i] <= v[i + 1])
			i--;
		return i < 0;
	}

	/**
	 * Tri � bulles qui trie de mani�re croissante un vecteur d'entiers
	 * 
	 * @param v un vecteur d'entiers
	 */
	public static void triBulles(int[] v) {
		int i, tmp;
		int j = v.length - 2;
		boolean swap = true;
		while (j >= 0 && swap) {
			swap = false;
			for (i = 0; i <= j; i++)
				if (v[i] > v[i + 1]) {
					tmp = v[i];
					v[i] = v[i + 1];
					v[i + 1] = tmp;
					swap = true;
				}
			j--;
		}
	}

	/**
	 * trie le vecteur de mani�re croissante
	 * 
	 * @param v est une liste d'entiers (Integer)
	 */
	public static void triBullesV2(List<Integer> v) {
		int i;
		Integer tmp;
		int nbSwap = 1;
		int j = v.size() - 2;

		while (j >= 0 && nbSwap > 0) {
			nbSwap = 0;
			for (i = 0; i <= j; i++)
				if (v.get(i) > v.get(i + 1)) {
					tmp = v.get(i);
					v.set(i, v.get(i + 1));
					v.set(i + 1, tmp);
					nbSwap++;
				}
			j--;
		}
	}

	/**
	 * Tri par insertion
	 * 
	 * @param v trie le vecteur de mani�re croissante
	 */
	public static void triInsertion(int[] v) {

		// A changer et impl�menter le tri par insertion
		Arrays.sort(v);

	}

}
