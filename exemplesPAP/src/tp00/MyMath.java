package tp00;

import java.util.List;

/**
 * 
 * @author Didier
 *
 */
public class MyMath {

	/**
	 * Calcule la factorielle de n
	 * 
	 * @param n entier positif
	 * @return n!
	 */
	public static long factorielle(int n) {
		assert n >= 0 && n < 21 : "n doit �tre un nombre positif";

		long y = 1;
		for (int i = 2; i <= n; i++)
			y = y * i;
		return y;
	}

	/**
	 * Calcule la factorielle de n
	 * 
	 * @param n entier positif <21
	 * @return n!
	 */
	public static long factorielle2(int n) {
		assert n >= 0 && n < 21 : "Le nombre doit �tre positif et inf�rieur � 21";
		long res = 1;
		// n est d�j� initialis�
		for (; n > 1; n--)
			res *= n;
		return res;
	}

	/**
	 * Calcule x^y
	 * 
	 * @param x r�el
	 * @param y entier positif
	 * @return
	 */
	public static double power(double x, int y) {
		assert y >= 0 : "Y doit �tre un entier positif";
		// Elimine les cas exposant 0
		if (y == 0)
			return 1.0;
		// Y>0
		double res = x;
		for (int i = 2; i <= y; i++)
			res = res * x;

		return res;
	}

	/**
	 * Calcule x^y
	 * 
	 * @param x r�el
	 * @param y entier positif
	 * @return
	 */
	public static double power2(double x, int y) {
		assert y >= 0 : "Y doit �tre un entier positif";
		// Elimine les cas exposant 0
		if (y == 0)
			return 1.0;
		if (y == 1)
			return x;
		// Y>1
		double res = x;
		int z = y >> 1;// z=y/2
		for (int i = 2; i <= z; i++)
			res *= x;
		res *= res;
		// Si le nombre est impaire, je mutiplie par x
		if ((y & 1) == 1) // ou (y % 2 !=0)
			res *= x;
		return res;
	}

	/**
	 * 
	 * @param a un entier >0
	 * @param b un entier >0
	 * @return le pgcd de a et b
	 */
	public static int pgcd(int a, int b) {
		assert a > 0 && b > 0 : "a et b doivent �tre >0";
		int reste;
		while (b != 0) {
			reste = a % b;
			a = b;
			b = reste;
		}
		return a;
	}

	/**
	 * Calcule le nombre de bits � 1
	 * 
	 * @param n un entier
	 * @return nb de bits � 1
	 */
	public static int nbUn(long n) {
		int cpt = 0;
		while (n != 0) {
			if ((n & 1) > 0)
				cpt++;
			n = n >>> 1;
		}
		return cpt;
	}

	/**
	 * Calcule le nombre de bytes pour coder ce caract�re en UTF8
	 * 
	 * @param c le caract�re
	 * @return nombre de bytes
	 */
	public static int nbBytesUtf8(char c) {
		// Type casting pour avoir le code du caract�re
		int res;
		int n = (int) c;
		if ((n & 0xFF80) == 0)
			res = 1;
		else if ((n & 0xF800) == 0)
			res = 2;
		else
			res = 3;
		return res;
	}

	/**
	 * V�rifie si un nombre est premier
	 * 
	 * @param n entier >1
	 * @return true si premier
	 */
	public static boolean estPremier(int n) {
		assert n > 1 : "n doit �tre un entier positif >1";
		boolean premier = n == 2 || n % 2 != 0;
		int d = 3;
		final int FIN = (int) Math.sqrt(n);
		while (premier && d <= FIN) {
			premier = n % d != 0;
			d = d + 2;
		}
		return premier;
	}

	public static void main(String[] args) {
		System.out.println(factorielle(20));
		System.out.println(factorielle2(3));
		System.out.println("---------------------------------");

		List<Integer> listePremier = List.of(1, 2, 3, 5, 7, 11, 13, 17);
		long sum = 1;
		for (Integer i : listePremier) {
			sum += i;
			System.out.println("somme= " + sum);
		}

		if (listePremier != null && listePremier.get(0) < 2)
			System.out.println("bic presque vide");
	}

}
