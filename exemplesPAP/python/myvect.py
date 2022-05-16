#Vérifie si un vecteur est trié
def estTrie(v : list):
    '''Vérifie si un vecteur est trié de manière croissante'''
    i = len(v) - 2
    while i >= 0 and v[i] <= v[i+1]:
        i = i - 1
    return i < 0

#TriBulle
def triBulles(v : list):
    '''Trie le vecteur de manière croissante (tri bulles)'''
    j = len(v) -2
    swap = True
    while j>=0 and swap:
        swap = False
        for i in range(j+1):
            if v[i] > v[i+1]:
                v[i], v[i+1] = v[i+1], v[i]
                swap = True
        j = j - 1

#Recherche binaire
def rechercheBin(v : list, nbr  : int)-> int:
    ''' Recherche nbr dans la liste V et retourne l'indice ou -1'''
    if len(v)==0:
        return -1
    a = 0
    b = len(v) - 1
    m = b // 2
    while a<b and v[m] != nbr:
        if nbr < v[m] :
            b = m - 1
        else :
            a= m + 1
        m = (a+b) // 2
    if v[m] == nbr :
        return m
    else :
        return -1

#A exécuter uniquement lorsqu'il s'agit du module main
if __name__ == "__main__":
    
    l1 = [3, 5, 8, 20, 30]
    print(rechercheBin(l1,20))
    print(rechercheBin(l1,3))
    print(rechercheBin(l1,25))