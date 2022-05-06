package exemplesNote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsExemples {

	public static void main(String[] args) {
		/**********************************
		 * Listes
		 ***********************************/
		// Liste non modifiable
		List<Integer> v1 = List.of(1, 2, 5);
		System.out.println(v1);
		// Liste modifiable mais de taille fixe
		List<Integer> v2 = Arrays.asList(1, 2, 5, 6);
		v2.set(0, 10);
		System.out.println(v2);

		// Liste vide extensible
		List<Integer> v3 = new ArrayList<>();
		v3.addAll(Arrays.asList(21, 33, 2, 9));
		System.out.println(v3);

		List<Integer> v = new ArrayList<>();
		v.addAll(Arrays.asList(10, 4, -3, 9));
		
		//Ajout de nouveaux �l�ments
		v.add(1, 99);//Ajoute un nouvel �l�ment et d�cale les autres vers la droite
		v.addAll(1, Arrays.asList(1, 2, 3));//Ajoute une liste d'�l�ments
		//Suppression
		v.remove(2);//retire l'�l�ment d'indice 2
		v.remove((Integer) (-3));//retire l'�l�ment -3
		v.removeIf(x -> x<5);//r�tire les �l�ments r�pondant � une condition
		
		//V�rifie si la liste contient un �l�ment
		System.out.println(v.contains(9)); 
		//R�cup�re l'�l�ment d'indice sp�cifi�
		System.out.println(v.get(0));
		
		//Remplace l'�l�ment d'indice indiqu�
	    v.set(0, 55);
		
		//Trier une liste
		v.sort(Integer::compare);//Tri en sp�cifiant un compateur
	
		Collections.sort(v);//Tri avec le comparateur des �l�ments
		System.out.println(v);
		
		//Cr�ation d'une sous-liste
		v2 = v.subList(1, 3);
		System.out.println(v2);

		/* 
		 * Parcourir une liste 
		 */
		// Parcourir une liste version classique
		for (int i = 0; i < v.size(); i++)
			System.out.print(v.get(i) + " , ");
		System.out.println();
		
		// Parcourir avec une boucle "For each"
		for (Integer elem : v)
			System.out.print(elem + " , ");
		System.out.println();

		// Avec un it�rateur
		var iter = v.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " , ");
		}
		System.out.println();

		/**********************************
		 * ENSEMBLES
		 ***********************************/
		// Ensemble non modifiable
		Set<Integer> ens1 = Set.of(1, 2, 3, 5, 8, 13);
		Set<Integer> ens2 = Set.of(1, 2, 4, 8, 16, 32);
		// ens modifiable non initialis�
		Set<Integer> e0 = new HashSet<>();
		// ens modifiable initialis�
		Set<Integer> e1 = new HashSet<>(ens1);
		Set<Integer> e2 = new HashSet<>(Arrays.asList(3, 6, 9, 12, 15));

		System.out.println(e0 + " " + e1 + " " + e2);
		System.out.println(e1.size());
		// Appartenance
		System.out.println(e2.contains(16));
		// Intersection
		e1.retainAll(ens2);
		System.out.println(e1);
		// exclusion
		e1.removeAll(ens2);
		System.out.println(e1);
		
		// Ajout d'un �l�ment (null est autoris� avec HashSet)
		e1.add(64);
		//Retire l'�l�ment
		e1.remove(64);
		
		/*
		 * Parcourir une liste
		 */
		// Parcourir avec ForEach
		for (Integer e : e2) {
			System.out.print(e + ",");
		}
		System.out.println();

		// Parcourir avec ForEach Lambda
		e2.forEach(e -> System.out.print(e + ","));
		System.out.println();

		// Parcourir avec un it�rateur
		var iter1 = e2.iterator();
		while (iter1.hasNext()) {
			System.out.print(iter1.next() + ",");
		}
		System.out.println();

		/**********************************
		 * Dictionnaire
		 ***********************************/
		// Map non modifiable v1
		Map<Integer, String> codesHttp1 = Map.of(200, "Succ�s", 301, "Indirection", 404, "Ressource non trouv�e");
		// Map non modifiable v2
		Map<Integer, String> codesHttp2 = Map.ofEntries(Map.entry(200, "Succ�s"), Map.entry(301, "Indirection"),
				Map.entry(404, "Ressource non trouv�e"));

		// Map modifiable
		Map<Integer, String> codesHttp3 = new HashMap<>();
		
		//Ajouter des �l�ments
		codesHttp3.put(200, "Succ�s");
		codesHttp3.put(301, "Indirection");
		codesHttp3.put(404, "Ressource non trouv�e");
		
		//R�cup�rer un �l�ment
		String res1=codesHttp1.get(200);
		System.out.println(res1);
		  //Si la cl� n'existe pas fourni une valeur par d�faut
		String res2=codesHttp1.getOrDefault(007, "James");
		System.out.println(res2);
		
		//Remplacer un �l�ment existant
		codesHttp1.replace(200, "Tout va bien");

		// Ensemble des cl�s
		System.out.println(codesHttp3.keySet());
		// Ensemble des entr�es
		System.out.println(codesHttp3.entrySet());
		// Collection des valeurs
		System.out.println(codesHttp3.values());
	}
}
