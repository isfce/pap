package jeu;

public class Hanoi {
	/**
	 * Indique les déplacements à faire pour déplacer n disques du piquet de d vers
	 * a
	 * 
	 * @param n nombre de disques
	 * @param d piquet de départ 0..2
	 * @param a piquet d'arrivée 0..2
	 */
	public static void deplacer(int n, int d, int a) {
		assert n > 0 && d > 0 && d < 3 && a > 0 && a < 3 : "Donnée(s) invalide(s)";
		if (n == 1)
			System.out.println("Depacer du piquet " + d + " vers piquet " + a);
		else {
			int i = 3 - d - a;
			deplacer(n - 1, d, i);
			deplacer(1, d, a);
			deplacer(n - 1, i, a);
		}
	}

	public static void main(String[] args) {
		deplacer(10, 0, 2);

	}

}
