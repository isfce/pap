package tp00;

public class TpMatrice {
	/**
	 * Initialise une matrice de 1 à n*m ligne par ligne
	 * 
	 * @param m une matrice n*m
	 */
	public static void initMat1(int[][] m) {
		int cpt = 1;
		for (int i = 0; i < m.length; i++)
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = cpt;
				cpt++;
			}
	}

	/**
	 * Affiche une matrice ligne par ligne
	 * 
	 * @param m la matrice
	 */
	public static void afficheMat(int[][] m) {

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++)
				System.out.printf("%3d  ", m[i][j]);
			System.out.println();
		}
	}

	/**
	 * Vérifie si une matrice carré est symétrique
	 * 
	 * @param m une matrice n*n d'entiers
	 * @return True si elle est symétrique
	 */
	public static boolean estSymetrique(int[][] m) {
		boolean sym = true;
		int i = 1;
		int j;
		while (i < m.length && sym) {
			j = 0;
			while (j < i && sym) {
				sym = m[i][j] == m[j][i];
				j++;
			}
			i++;
		}
		return sym;
	}

	public static void main(String[] args) {

		int[][] m1 = new int[3][3];
		initMat1(m1);

		int[][] m2 = { { 1, 2, 3 }, { 2, 2, 4 }, { 3, 4, 3 } };
		afficheMat(m2);

	}

}
