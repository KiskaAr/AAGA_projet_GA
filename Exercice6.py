# exercice 6
import os

# Reponse 1
def generateur_generique( a, c, m, xn):
    return ( a*xn + c) % m

# Reponse 2
x1 = generateur_generique(12, 0, 101, 11)
for i in range(0,10):
    print(x1)
    x1 = generateur_generique(12, 0, 101, x1)
    
# Reponse 3
fichier = open("coordones2d.txt", "w")
x1 = generateur_generique(12, 0, 101, 12345)

for i in range(0,100):
    x2 = generateur_generique(12, 0, 101, x1)
    fichier.write(str(round(x1/101.0, 5))+","+str(round(x2/101.0 ,5))+"\n")
    x1=x2
fichier.close()

# Reponse 4
fichier2 = open("coordones3d.txt", "w")
x1 = generateur_generique(12, 0, 101, 12345)

for i in range(0,100000):
    x2 = generateur_generique(12, 0, 101, x1)
    x3 = generateur_generique(12, 0, 101, x2)
    fichier2.write("["+str(round(x1/101.0, 5))+","+str(round(x2/101.0 ,5))+","+str(round(x3/101.0 ,5))+"],\n")
    x1=x2
    
fichier2.close()
