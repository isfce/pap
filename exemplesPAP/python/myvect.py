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

def sommeMat(m1,m2):
    '''m1 et m2 sont deux matrices de même taille
       la fonction retourne une nouvelle matrice ou
       m3[i][j] = m1[i][j] + m2[i][j]'''
    return [[m1[i][j] + m2[i][j] for j in range(len(m1[0]))]
         for i in range(len(m1))]

def sommeMat2(m1,m2):
    '''m1 et m2 sont deux matrices de même taille
       la fonction retourne 
       m1[i][j] = m1[i][j] + m2[i][j]'''
    for i in range(len(m1)):
        for j in range(len(m1[0])):
            m1[i][j] = m1[i][j] + m2[i][j]
    return m1
    
    
#A exécuter uniquement lorsqu'il s'agit du module main
if __name__ == "__main__":
    
    l1 = [3, 5, 8, 20, 30]
    print(rechercheBin(l1,20))
    print(rechercheBin(l1,3))
    print(rechercheBin(l1,25))
    m1=[[1,2,3],[4,5,6]]
    m2=[[1,4,2],[9,2,5]]
    print(sommeMat(m1,m2))