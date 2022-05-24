package tp03;

import tp00.TpMatrice;

public class Magique {
	/**
	 * Calcul la somme d'une ligne/colonne/diagonale
	 * 
	 * @param m    matrice carr�e
	 * @param i    indice initial pour la ligne
	 * @param j    indice initial pour la colonne
	 * @param diri incr�ment ligne
	 * @param dirj incr�ment colonne
	 * @return
	 */
	public static int calculSomme(int[][] m, int i, int j, int diri, int dirj) {
		assert (i == 0 || i == m.length - 1) && (j == 0 || j == m.length - 1) : "Bien initialiser i et j";
		int somme = m[i][j];
		int n = m.length;// taile de la matrice
		for (int nb = 2; nb <= n; nb++) {
			i += diri;
			j += dirj;
			somme += m[i][j];
		}
		return somme;
	}

	/**
	 * V�rifie si toutes les sommes lignes/colonnes/diag sont �gales
	 * 
	 * @param m matrice carr�e d'entiers
	 * @return true si les sommes sont �gales
	 */
	public static boolean estMagique1(int[][] m) {
		boolean ok = true;
		// somme de r�f�rence (celle de la 1�re ligne)
		int sommeRef = calculSomme(m, 0, 0, 0, 1);
		int taille = m.length;
		// Lignes 1 � n-1
		int i = 1;
		while (i < taille && ok) {
			ok = (calculSomme(m, i, 0, 0, 1) == sommeRef);
			i++;
		}
		// Colonne 0 � n-1
		int j = 0;
		while (j < taille && ok) {
			ok = (calculSomme(m, 0, j, 1, 0) == sommeRef);
			j++;
		}
		// Diag1
		ok = ok && (calculSomme(m, 0, 0, 1, 1) == sommeRef);
		// Diag2
		ok = ok && (calculSomme(m, taille - 1, 0, -1, 1) == sommeRef);

		return ok;
	}

	/**
	 * V�rifie que la somme d'une ligne ou colonne ou une des 2 diagonales
	 * principales soient �gales � la somme de r�f�rence
	 * 
	 * @param m        matrice carr�e d'entiers >=0
	 * @param i        indice de ligne initial
	 * @param j        indice de colonne initial
	 * @param diri     incr�ment de ligne
	 * @param dirj     incr�ment de colonne
	 * @param sommeRef somme � obtenir
	 * @return true si la somme = sommeMax
	 */
	public static boolean verifieSomme(int[][] m, int i, int j, int diri, int dirj, int sommeRef) {
		int somme = m[i][j];
		int nb = m.length;
		while (somme <= sommeRef && nb > 1) {
			i += diri;
			j += dirj;
			somme += m[i][j];
			nb--;
		}
		return somme == sommeRef;
	}

	/**
	 * V�rifie si toutes les lignes, colonnes, diagonles principales donnent la m�me
	 * somme
	 * 
	 * @param m matrice carr�e d'entiers
	 * @return vrai si toutes les sommes sont �gales et les �l�ments de m sont >=0
	 */
	public static boolean estMagique2(int[][] m) {
		// V�rifier que tous �l�ments sont positifs
		int i = 0, j;
		int taille = m.length;
		boolean ok = true;
		while (ok && i < taille) {
			j = 0;
			while (ok && j < taille) {
				ok = m[i][j] >= 0;
				j++;
			}
			i++;
		}
		if (!ok)
			return false;

		// V�rifier les sommes
		// Calcule la somme de r�f�rence (ligne 0)
		int sommeRef = 0;
		for (int elem : m[0])
			sommeRef += elem;
		// V�rifie les sommes des lignes
		i = 1;
		while (i < taille && ok) {
			ok = verifieSomme(m, i, 0, 0, 1, sommeRef);
			i++;
		}
		// V�rifie les sommes des colonnes
		j = 0;
		while (j < taille && ok) {
			ok = verifieSomme(m, 0, j, 1, 0, sommeRef);
			j++;
		}
		// V�rifie diagonales
		ok = ok && verifieSomme(m, 0, 0, 1, 1, sommeRef);
		ok = ok && verifieSomme(m, taille - 1, 0, -1, 1, sommeRef);
		return ok;
	}

	/**
	 * V�rifie si toutes les lignes, colonnes, diagonales donnent la m�me somme
	 * 
	 * @param m matrice carr�e
	 * @return vrai si toutes les sommes sont �gales et et on doit avoir tous les
	 *         nombres de 1 � n*n
	 */
	public static boolean estMagique3(int[][] m) {
		// v�rifie que les nbrs de 1 � n*n sont pr�sents
		boolean ok = true;
		// TODO A faire chez vous

		// si Ok v�rifie les sommes
		ok = ok && estMagique2(m);
		return ok;
	}

	/**
	 * Construction d'un carr� magique
	 * 
	 * @param n    dimension
	 * @param diri
	 * @param dirj
	 * @return
	 */
	public static int[][] creeCarreMagique(int n, int diri, int dirj) {
		assert n % 2 != 0 : "La taille doit �tre impaire";
		int[][] m = new int[n][n];
		// Calcul la position initiale de i et j pour le un
		int i = 0;
		int j = n / 2;

		int cpt = 0;
		for (int nb = 1; nb <= n * n; nb++) {
			m[i][j] = nb;
			cpt++;
			if (cpt < n) {// Si pas de collision on avant circulairement dans la direction
				i = Math.floorMod(i + diri, n); // modulo
				j = Math.floorMod(j + dirj, n); // modulo
			} else {// En cas de collision on va sur la case en dessous
				i = Math.floorMod(i + 1, n); // modulo
				cpt = 0;
			}
		}
		return m;
	}

	public static void main(String[] args) {
		int[][] m1 = { { 1, 2 }, { 3, 1 } };
		int[][] m2 = { { 1, 1 }, { 1, 1 } };
		int[][] m3 = { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } };
		System.out.println(estMagique1(m1));
		System.out.println(estMagique1(m2));
		System.out.println(estMagique1(m3));

		int[][] m4 = creeCarreMagique(5, -1, 1);
		TpMatrice.afficheMat(m4);
		System.out.println(estMagique1(m4));

	}

}
