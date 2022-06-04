class Othello:
    __directions=[(-1,0),(-1,1),(0,1),(1,1),
                   (1,0),(1,-1),(-1,0),(-1,-1)]
    def __init__(self):
        
        self.__initPartie = False
        self.__BLANC = 1
        self.__NOIR = -1
        
    def initPartie(self):
        self.__jeu = [[0 for i in range(8)] for j in range(8)]
        self.__jeu[3][3] = self.__BLANC
        self.__jeu[4][4] = self.__BLANC
        self.__jeu[4][3] = self.__NOIR
        self.__jeu[3][4] = self.__NOIR
        self.__nbBlancs = 2
        self.__nbNoirs = 2
        self.__tourDesBlancs = False
        self.__choixPossiblesJoueur = set([(3,2),(2,3),(5,4),(4,5)])
        self.__initPartie = True
        
    def start(self):
        if (not self.__initPartie):
            print("La partie doit être initialisée avant de démarrée");
        else:
            finPartie = False
            abandon = False
            while (not finPartie and not abandon):
                self.__afficheJeu()
                #mémorise la couleur du joueur qui va jouer
                couleurJoueur = "Blancs" if self.__tourDesBlancs else  "Noirs"
                passe = len(self.__choixPossiblesJoueur) == 0
                #passe ou joue
                if (passe):# Affiche que le joueur doit passer
                    print("Le joueur ayant les " + couleurJoueur + " doit passer")
                else: # introduire son choix
                    # Indique qui doit jouer
                    print(f"Le joueur avec les {couleurJoueur} doit faire son choix (x,y): ")
                    # Tant que la donnée entrée n'est pas valable on boucle
                    choixValide = False
                    while (not abandon and not choixValide):
                        # entrée entre 0 et 7 pour x et y un nombre négatif signifie que le joueur
                        # abandonne
                        choixJ = self.__lireInputJoueur()
                        abandon = choixJ[0] < 0 or choixJ[1] < 0 #Une entrée <0 signifie un abandon
                        if not abandon:
                            # vérifie si le coup est valide
                            choixValide = self.__verifieValidite(choixJ)
                            if not choixValide:
                                print("La position n'est pas valide")
                    if not abandon:
                        # Retourne les pions et ajuste nbPions en jeu
                        self.__retournePions(choixJ)
                # mémorise le nbr de choix du joueur avant de changer de joueur
                oldChoixPossible = len(self.__choixPossiblesJoueur)
                if not abandon:
                    #au tour de l'autre joueur
                    self.__tourDesBlancs = not self.__tourDesBlancs
                    #Calcul les positions possibles pour l'autre joueur
                    self.__ajusteChoixJoueur();
                # si abandon, si plus de choix possible ou plus de pion
                finPartie = abandon or ((64 - self.__nbBlancs - self.__nbNoirs) == 0) or ((len(self.__choixPossiblesJoueur) + oldChoixPossible) == 0 )
                #Fin While
            print("FIN PARTIE:")
            self.__afficheJeu()
            #Affiche le résultat de la partie
            if abandon:
                resultat = "Le joueur " + couleurJoueur + " a abandonné"
            elif self.__nbBlancs == self.__nbNoirs:
                resultat = "Partie nulle"
            elif self.__nbBlancs > self.__nbNoirs:
                resultat = "Les blancs ont gagné avec " + str(self.__nbBlancs) + " contre " + str(self.__nbNoirs)
            else:
                resultat = "Les noirs ont gagné avec " + str(self.__nbNoirs) + " contre " + str(self.__nbBlancs)
            print(resultat)
            #Il faut démarrer une nouvelle partie
            self.__initPartie = False;
            
    def __ajusteChoixJoueur(self):
        self.__choixPossiblesJoueur.clear()
        # TODO
        
    def __checkDirection(self, p, couleurJ, direction):
        ok = False
        #TODO
        return ok
        
    def __estDansJeu(self, x, y):
        return x >= 0 and y >= 0 and x < 8 and y < 8
        
    def __retournePions(self, choixJ):
        pass
        #TODO
        
    def __retournePionsDir(self, x, y, dir):
        nbPionsRetourne = 0
        #TODO
        return nbPionsRetourne
        
    def __verifieValidite(self, pos):
        return pos in self.__choixPossiblesJoueur
        
    def __afficheJeu(self):
        print('Affiche Jeu')
        
    def __lireInputJoueur(self):
        y = -1;
        #lit la ligne
        x = self.__lireEntier()
        if x >= 0: # si x>=0 (pas abandon
        # lit la colonne
            y = self.__lireEntier()
            if (y < 0):
                x = -1 #si y<0 ==> on mets aussi x à -1
        return (x, y)
        
    def __lireEntier(self):
        x = -1
        ok = False
        # attend un nombre <8
        while not ok:# lit la prochaine ligne
            try:
                x = int(input("Entrez un nombre: "))
                ok = x < 8
                if (not ok):
                    print("Entrez une valeur entre 0 et 7 , ou -1 pour un abandon")
            except ValueError:
                print("Entrez un nombre!")
                ok = False
        return x;
        
reversi = Othello()
reversi.initPartie()
reversi.start()
    

