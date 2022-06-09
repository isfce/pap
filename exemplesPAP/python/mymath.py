
def factorielle(n: int)-> int:
    ''' Calcule la factorielle de n  '''
    assert type(n)== int and n>=0, "n doit être un entier positif"
    y=1
    for n in range(n,1,-1):
        y=y*n
    return y # Retourne n!

def factorielleR(n: int)-> int:
    ''' Calcule la factorielle de n  (récursif)'''
    assert type(n)== int and n>=0, "n doit être un entier positif"
    if n == 0 :
        res = 1
    else:
        res = n * factorielleR(n-1)
    return res # Retourne n!

def power(x: float,y: int = 2)->float:
    '''Calcule x^y avec y entier positif '''
    assert  isinstance(x, (int, float))  and isinstance(y, int) and y>= 0 , 'Erreur x: réel, y:entier >=0'
    
    if y==0 :
        return 1
    # Y>0
    res = x
    for i in range(1,y):
        res = res * x
        
    return res

def power2(x: float,y: int)-> float:
    '''Calcule x^y avec y entier'''
    assert isinstance(x, (int, float))  and isinstance(y, int), 'Erreur x: réel, y:entier'
    
    if y==0 : return 1
    # Y>0
    yPositif= y>0
    y= abs(y)
    if y==1 or x==0 or x==1: return x if yPositif else 1/x
    # Y est positif maintenant
    res = x
    for i in range(1,y//2):
        res = res * x
    res*= res
    #si y est impaire alors res<-res*x
    if y%2 != 0:
        res*=x
        
    return res if yPositif else 1/res

def power3(x: float,y: int)-> float:
    '''Calcule x^y avec y entier (récursif)'''
    assert isinstance(x, (int, float))  and isinstance(y, int), 'Erreur x: réel, y:entier'
    
    if y==0 : return 1
    # Y>0
    yPositif= y>0
    y= abs(y)
    if y==1 or x==0 or x==1: return x if yPositif else 1/x
    # Y est positif maintenant
    res = power3(x,y//2)
    res = res * res
    #si y est impaire alors res<-res*x
    if y%2 != 0:
        res = res * x
        
    return res if yPositif else 1/res

def pgcd(a: int,b: int)-> int:
    '''Calcule le pgcd des nombres a>0 et b>0 '''
    assert type(a)== int and type(b)== int and a>0 and b>0, " a et b doivent être > 0"
    while b!=0:
        a, b = b, a%b
    return a

def nbUnV1(n: int)-> int:
    '''Calcule le nombre de bits à 1'''
    assert type(n) == int and n>=0, 'Le nombre doit être un entier positif'
    cpt = 0
    masque = 1
    taille = n.bit_length()
    for i in range(taille):
        if (n & masque) > 0 :
            cpt = cpt + 1
        masque = masque <<1
    return cpt, taille

def nbUn(n: int)-> int:
    '''Calcule le nombre de bits à 1'''
    assert type(n) == int and n>=0, 'Le nombre doit être un entier positif'
    cpt = 0
    while n != 0:
        if (n & 1) > 0 :
            cpt = cpt + 1
        n = n >> 1
    return cpt

def nbBytesUtf8(c : str)-> int:
    '''Retourne le nombre de bytes pour coder ce car en utf8'''
    assert type(c) == str and len(c) == 1, "Doit être un seul caractère"
    n = ord(c) #n <-- code unicode du caractère
    if n & 0xFF80 == 0 :
        res = 1
    elif n & 0xF800 == 0 :
        res = 2
    else: res = 3
    
    return res

def nbBytesUtf8_V2(c : str)-> int:
    '''Retourne le nombre de bytes pour coder ce car en utf8'''
    assert type(c) == str and len(c) == 1, "Doit être un seul caractère"
    n = ord(c) #n <-- code unicode du caractère
    if n & 0xFF80 == 0 :
        return  1
    if n & 0xF800 == 0 :
        return  2
    return  3

#Exemples utilisant un nombre variable d'aguments
def affiche(*chaine,separateur=','):
    '''Exemple d'appel avec un nombre variable
       d'arguments ==> liste'''
    for c in chaine:
        print(c,end=separateur)
    print()

def connectionDb(**param):
    '''Exemple d'appel avec un nombre variable
       d'arguments nommés ==> dictionnaire'''
    for e in list(param.items()):
       print(f'clé: {e[0]} ==> valeur: {e[1]}')

#Variable globale au module      
cpt = 0

def cube(a):
    global cpt 
    cpt = cpt + 1 #Incrément le cpt (indique le nbr d'appels)
    return a * a *a

#A exécuter uniquement lorsqu'il s'agit du module main
if __name__ == "__main__":
    
    connectionDb(login='admin',password='adminPW')
    affiche(1,2,'T',4,5,'_')
    affiche(1,2,'T',4,5,separateur='_')
    car='€'
    print(f'Le caractère {car} à besoin de {nbBytesUtf8(car)} bytes')
    print(f'Nombre de bits à 1 de 6 est {nbUn(6)} ')
    power2(2,-1)
    d=int(input("Entrez un nombre: "))
    print(d,"  ",type(d))
    res=factorielle(d)
    print(f' La factorielle de {d} est {res} ')
    print(f' le pgcd de 15 et 9 = {pgcd(15,9)}')
    
    