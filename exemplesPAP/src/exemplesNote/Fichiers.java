package exemplesNote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Fichiers {
	/**
	 * Charge un fichier texte
	 * 
	 * @param nom     chemin et nom du fichier
	 * @param charset encodage du fichier
	 * @throws IOException
	 */
	public static void loadFile(String nom, Charset charset) throws IOException {
		// Création d'un objet File
		File fichier = new File(nom);
		// Crée une lecture d'un fichier texte dans l'encodage donné
		// ajoure un buffer pour la performance
		// utilise un try with ressource pour que les resources soient fermées
		// automatiquement
		try (FileReader rd = new FileReader(fichier, charset); BufferedReader br = new BufferedReader(rd);) {
			System.out.println("Encoding: " + rd.getEncoding());
			String ligne;
			List<String> mots;
			// lit chaque ligne
			while ((ligne = br.readLine()) != null) {
				// crée une liste avec chaque mots (séparateur ;)
				mots = List.of(ligne.split(";"));
				System.out.println(mots);
			}
		}
	}

	/**
	 * Sauvegarde la liste de lignes sur un fichier texte
	 * 
	 * @param nom
	 * @param lignes
	 * @param encodage
	 */
	public static void saveToFile1(String nom, List<String> lignes, Charset charset) {
		// création d'un fichier
		File file = new File(nom);
		// utilise un FileWrite et un buffer dans un try with resources
		try (FileWriter fw = new FileWriter(file.getAbsoluteFile(),charset); BufferedWriter bw = new BufferedWriter(fw);) {

			// créer le fichier s'il n'existe pas
			if (!file.exists()) {
				file.createNewFile();
			}
			// Ecriture de chaque ligne dans le fichier
			for (String ligne : lignes) {
				bw.write(ligne);
			}
			// fermeture du fichier
			bw.close();//fetch et close
		} catch (IOException e) {
			System.err.println("Problème: "+e.getMessage());
		}
	}

	/**
	 * Sauve la liste de lignes dans un fichier avec l'encodage donnée
	 * 
	 * @param nom
	 * @param lignes
	 * @param encodage
	 * @throws IOException
	 */
	public static void saveToFile2(String nom, List<String> lignes, Charset charset) throws IOException {
		Path fichier = Path.of(nom);
		// La commande suivante écrit les lignes en écrasant le texte déjà présent dans
		// le fichier
		Files.write(fichier, lignes, charset);

		// Pour écrire à la suite du fichier, il faut utiliser la commande suivante
		// Files.write(fichier, lignes, charset, StandardOpenOption.APPEND);

	}

	public static void main(String[] args) {
		//charge 2 fichiers
		try {
			loadFile("c:python/texte1.txt", Charset.defaultCharset());
			loadFile("c:python/texte2.txt", Charset.forName("UTF8"));
			//sauve un fichier v1
			saveToFile1("c:python/texte3.txt", List.of("Didier Vo", "Alain Wafflard"), Charset.defaultCharset());
			//sauve u fichier v2
			saveToFile2("c:python/texte4.txt", List.of("Testé un € avec àâè", "le ^ et iï","une résistance de 4K \u03A9 "), Charset.forName("utf8"));
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier n'existe pas !" + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problème d'entrée-sortie" + e.getMessage());
		}
	}
}
