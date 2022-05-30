package jeu;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Othello {
	// Permet de définir une position ou une direction
	private record Position(int x, int y) {
	};

	// liste des 8 directions
	private static final Position[] directions = { new Position(-1, 0), new Position(-1, 1), new Position(0, 1),
			new Position(1, 1), new Position(1, 0), new Position(1, -1), new Position(0, -1), new Position(-1, -1) };
	// code pour blanc et noirs
	private static final int BLANC = 1;
	private static final int NOIR = -1;
	// Le jeu 8*8
	private int[][] jeu;
	// Nombre de noirs et nombre de blancs sur le jeu
	private int nbBlancs, nbNoirs;
	// Qui doit jouer
	boolean tourDesBlancs;
	// Partie terminée
	private boolean finPartie;
	// Partie initialisée
	private boolean init = false;
	// position choisie par le joueur
	private Position choixJ;
	// permet de lire les entrées
	private Scanner scan = new Scanner(System.in);
	// Position autorisée pour le joueur (noir ou blanc)
	private Set<Position> choixPossiblesJoueur = new HashSet<>();

	/**
	 * Initialise une nouvelle partie Doit être appelé avant de commencer une partie
	 */
	public void initPartie() {
		// crée la matrice
		jeu = new int[8][8];
		// mets les 4 pions du départ
		jeu[3][3] = BLANC;
		jeu[4][4] = BLANC;
		jeu[4][3] = NOIR;
		jeu[3][4] = NOIR;
		// init variables
		nbBlancs = 2;
		nbNoirs = 2;
		// possibilités choix Noirs
		choixPossiblesJoueur
				.addAll(List.of(new Position(3, 2), new Position(2, 3), new Position(5, 4), new Position(4, 5)));

		tourDesBlancs = false;// au noirs à jouer
		finPartie = false;
		init = true;
	}

	/**
	 * Lance la partie initialisée
	 */
	public void start() {
		boolean abandon = false;
		boolean passe;// lorsque le joueur doit passer
		boolean choixValide = false; // choix de l'entrée est une position valide
		int oldChoixPossible; // le nombre de possibilité du joueur précédent
		String couleurJoueur = "Noirs"; // Le nom de la couleur du joueur qui doit jouer
		// Vérifie si la partie a été initialisée
		if (!init)
			System.out.println("La partie doit être initialisée avant de démarrée");
		else {
			// boucle générale de la partie
			while (!finPartie && !abandon) {
				afficheJeu();
				// mémorise la couleur du joueur qui va jouer
				couleurJoueur = tourDesBlancs ? "Blancs" : "Noirs";
				passe = choixPossiblesJoueur.isEmpty();
				// passe ou joue
				if (passe) {// Affiche que le joueur doit passer
					System.out.println("Le joueur ayant les " + couleurJoueur + " doit passer");
					try {// petite pause
						Thread.sleep(2000);
					} catch (InterruptedException e) {
					}
				} else // introduire son choix
				{ // Indique qui doit jouer
					System.out.println("Le joueur avec les " + couleurJoueur + " doit faire son choix (x,y): ");

					// Tant que la donnée entrée n'est pas valable on boucle
					do {
						/*
						 * entrée entre 0 et 7 pour x et y un nombre négatif signifie que le joueur
						 * abandonne
						 */
						choixJ = lireInputJoueur();
						abandon = choixJ.x < 0 || choixJ.y < 0;// Une entrée <0 signifie un abandon
						if (!abandon) {
							// vérifie si le coup est valide
							choixValide = verifieValidite(choixJ);
							if (!choixValide)
								System.out.println("La position n'est pas valide");
						}
					} while (!abandon && !choixValide);

					if (!abandon) {
						// Retourne les pions et ajuste nbPions en jeu
						retournePions(choixJ);
					}

				}
				// mémorise le nbr de choix du joueur avant de changer de joueur
				oldChoixPossible = choixPossiblesJoueur.size();
				if (!abandon) {
					// au tour de l'autre joueur

					tourDesBlancs = !tourDesBlancs;
					// Calcul les positions possibles pour l'autre joueur
					ajusteChoixJoueur();
				}
				// si abandon, si plus de choix possible ou plus de pion
				finPartie = abandon || (64 - nbBlancs - nbNoirs) == 0
						|| choixPossiblesJoueur.size() + oldChoixPossible == 0;
			}
			System.out.println("FIN PARTIE:");
			afficheJeu();
			// Affiche le résultat de la partie
			String resultat;
			if (abandon)
				resultat = "Le joueur " + couleurJoueur + " a abandonné";
			else if (nbBlancs == nbNoirs)
				resultat = "Partie nulle";
			else if (nbBlancs > nbNoirs)
				resultat = "Les blancs ont gagné avec " + nbBlancs + " contre " + nbNoirs;
			else
				resultat = "Les noirs ont gagné avec " + nbNoirs + " contre " + nbBlancs;
			System.out.println(resultat);

			// Il faut démarrer une nouvelle partie
			init = false;
			scan.close();
		}
	}

	/**
	 * Calcule les cases disponibles pour le prochain joueur Mets dans
	 * choixPossiblesJoueur les positions valides
	 * 
	 * @param dernierChoix dernier pion posé
	 */
	private void ajusteChoixJoueur() {
		// TODO
	}

//
	/**
	 * Vérifie s'il existe un fourchette pour le joueur de couleurJ
	 * 
	 * @param p         position de départ pour la recherche
	 * @param couleurJ  couleur du joueur qui doit jouer
	 * @param direction de la recherche d'une fourchette
	 * @return true si fourchette possible
	 */
	private boolean checkDirection(Position p, int couleurJ, Position direction) {

		boolean ok = false;
		// TODO
		return ok;
	}

	/**
	 * Vérifie si x et y sont dans le jeu 0<=x<8 et 0<=y<8
	 * 
	 * @param x position ligne
	 * @param y position colonne
	 * @return true si dans le jeu
	 */
	private boolean estDansJeu(int x, int y) {
		return x >= 0 && y >= 0 && x < 8 && y < 8;
	}

	/**
	 * Retourne les pions du jeu (pion joué et pions à retourner) et ajuste nbBlancs
	 * et nbNoirs
	 * 
	 * @param x position valide
	 * @param y position valide
	 */
	private void retournePions(Position choixJ) {
		// TODO
	}

	/**
	 * Retourne les pions dans une direction donnée s'il existe une fourchette le
	 * pion de joueur est déjà mis
	 * 
	 * @param x   position ligne du pion joué
	 * @param y   position colonne du pion joué
	 * @param dir direction pour la recherche de fourchette
	 * @return le nombre de pions retournés
	 */
	private int retournePions(int x, int y, Position dir) {
		int nbPionsRetourne = 0;
		// TODO

		return nbPionsRetourne;
	}

	/**
	 * Vérifie si le coup est un coup possible
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean verifieValidite(Position pos) {
		return this.choixPossiblesJoueur.contains(pos);
	}

	/**
	 * Affiche le jeu
	 * 
	 */
	private void afficheJeu() {
	//TODO
	}

	/**
	 * Lit une position x et y sur la console x et y doit être entre 0 et 7 pour une
	 * position -1 signifie passe <-1 signifie un abandon
	 * 
	 * @return Position valable
	 */
	private Position lireInputJoueur() {
		int y = -1;
		// lit la ligne
		int x = lireEntier();
		if (x >= 0)// si x>=0 (pas abandon
		{// lit la colonne
			y = lireEntier();
			if (y < 0)
				x = -1;// si y<0 ==> on mets aussi x à -1
		}
		// return choixPossiblesJoueur.stream().findFirst().get();
		return new Position(x, y);
	}

	/**
	 * Lit une entrée entre 0 et 7 ou négative pour abandon
	 * 
	 * @return le nombre
	 */
	private int lireEntier() {
		String input;
		int x = -1;
		boolean ok;
		// attend un nombre <8
		do {// lit la prochaine ligne
			ok = false;
			input = scan.nextLine();
			try {// parse un entier
				x = Integer.parseInt(input);
				// vérifie validité du nombre
				ok = x < 8;
				if (!ok)
					System.err.println("Entrez une valeur entre 0 et 7 , ou -1 pour un abandon");
			} catch (NumberFormatException e) {
				System.err.println("Entrez un nombre!");
			}
		} while (!ok);
		return x;
	}

	public static void main(String[] args) {
		Othello reversi = new Othello();
		reversi.initPartie();
		reversi.start();
	}

}
