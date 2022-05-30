def load(nom, separateur=' ', encoding='cp1252'):
    '''Lit un fichier et découpe chaque ligne en mots'''
    f=open(nom,encoding = encoding)
    lignes=[]#liste avec les lignes
    for ligne in f:
        lignes+=ligne;
        l=ligne.split(separateur)
        print(len(l), ligne)
    f.close
    return lignes

def save(nom, lignes, encoding='cp1252'):
    '''Ecrit dans un fichier texte avec l'encodage'''
    f=open(nom,'w',encoding = encoding)
    for ligne in lignes:
        f.write(ligne)
    f.close
try:
    load('texte1.txt')
    lignes=load('texte2.txt',separateur=';',encoding="utf8")
    save('texte5.txt',lignes)
except IOError as e:
    print(f'Le fichier {e.filename} n\'existe pas' )
        
    