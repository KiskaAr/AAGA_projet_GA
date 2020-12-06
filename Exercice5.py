# coding=utf-8

##exercice 4
def algorithmek(x1):
    x = x1
    y = x / 10 ** 9
    #print("etape 1, x = "+str(x)+" y= "+str(y)+"\n")
    for i in range(0, y + 1 ):
        z = (x/10**8) % 10
        trouve = False;
        #print("etape 2, x = "+str(x)+" y= "+str(y)+"\n")
        if ((trouve) or (3 == z +3)):
            trouve = True
            if( x < 5 * 10**9):
                x = x + 5 * 10**9
            #print("etape 3, x = "+str(x)+" y= "+str(y)+"\n")
        if ((trouve) or (4 == z +3)):
            trouve = True
            x = (x*x / 10**5) % 10**10
            #print("etape 4, x = "+str(x)+" y= "+str(y)+"\n")
        if ((trouve) or (5 == z +3)):
            trouve = True
            x = (1001001001 * x) % 10**10
            #print("etape 5, x = "+str(x)+" y= "+str(y)+"\n")
        if ((trouve) or (6 == z +3)):
            trouve = True
            if x < 10**8 :
                x = x + 9814055677
            else :
                x = 10**10 - x
            #print("etape 6, x = "+str(x)+" y= "+str(y)+"\n")
        if ((trouve) or (7 == z +3)):
            trouve = True
            x= (10**5) *(x % 10**5) + x/10**5
            #print("etape 7, x = "+str(x)+" y= "+str(y)+"\n")
        if ((trouve) or (8 == z +3)):
            trouve = True
            x = (1001001001 * x) % 10**10
            #print("etape 8, x = "+str(x)+" y= "+str(y)+"\n")
        if ((trouve) or (9 == z +3)):
            trouve = True
            nombre = str(x)
            nombre_1 =""
            for i in range(0 , len(nombre)):
                if int(nombre[i]) > 0 :
                    nombre_1 = nombre_1+str(int(nombre[i]) -1)
                else :
                    nombre_1 = nombre_1+ nombre[i] 
            x = int(nombre_1)
            #print("etape 9, x = "+str(x)+" y= "+str(y)+"\n")
        if ((trouve) or (10 == z +3)):
            trouve = True
            if x < 10**5 :
                x= x*x+99999
            else: 
                x = x - 99999
            #print("etape 10, x = "+str(x)+" y= "+str(y)+"\n")
        if ((trouve) or (11 == z +3)):
            trouve = True
            while x < 10**9 :
                x = 10*x
            #print("etape 11, x = "+str(x)+" y= "+str(y)+"\n")
        if ((trouve) or (12 == z +3)):
            trouve = True
            x = (x * (x - 1)/10**5) % 10**10
            #print("etape 12, x = "+str(x)+" y= "+str(y)+"\n")
        if y > 0 :
            y = y - 1
            #print("etape 13, x = "+str(x)+" y= "+str(y)+"\n")
        else :
            return x
            


def calculXi(n, f, X0):
    Xnc = X0
    for i in range(n):
        Xnc = f(Xnc)
    return Xnc

def detect_periode(f , X0):
    #calcul de la valeur de n
    n = 0
    egalite = False 
    Xn = f(X0)
    X2n = f(Xn)
    if Xn == X2n : 
        egalite = True

    Xn_1 = Xn
    X2n_1 = X2n
    while egalite == False :
        Xn = f(Xn_1)
        X2n = f(f(X2n_1))
        print(str(Xn)+" , "+ str(X2n))
        if Xn == X2n : 
            egalite = True
        Xn_1 = Xn
        X2n_1 = X2n
        n += 1
    print("n trouvé "+str(n))
   
    #calcul de la période 
    egalite = False
    #p correspond à la longueur de la période 
    p = 0
    Xnp = Xn
    while egalite == False: 
        Xn1 = f(Xnp)
        if Xn1 == Xn :
            egalite = True
        p += 1
        Xnp = Xn1
    
    print("p trouvé "+str(p))

    # calcul de mu
    egalite = True
    mu = n
    while egalite == True:
        Xmu = calculXi(mu, f, X0)
        # Xn-1+λ
        print("p ="+str(p))
        Xmu_p = calculXi(mu+p, f, X0)
        print("mu = "+str(Xmu) +"mu periode = "+str(Xmu_p))
        if Xmu != Xmu_p :
            egalite = False
        mu-=1
        print("mu trouvé "+str(mu))
    

    return mu , p

#algorithmek(5162835038)
muu , periode = detect_periode(algorithmek, 123456)
print("mu = "+str(muu) +"periode = "+str(periode))
