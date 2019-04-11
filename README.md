# ProjetGraphes - DELPLANQUE Thibaut & NAAJI Dorian

# L'ensemble des résultats dont disponibles dans deux fichier Resultats.xlsx (Excel) et Resultats.ods (openDocument) à la racine de l'archive et du repository github.

## repository github
[github - ProjetGraphes](https://github.com/DorianNaaji/ProjetGraphes)

## Question 1 :

Les fichiers sont chargés grâce aux fonctions :
 + `ProjetGraphes.loadGraphes()`
 + `Graphe.load(String filename)`
 
 
## Question 2 :
 
 Le nombre de sommets et d'arêtes du graphe ont été déterminés grâce aux fonctions :
  + `Graphe.getNbSommets()`
  + `Graphe.getNbAretes()`

## Question 3 :

Le nombre de composantes connexes du graphe sont déterminées grâce à :
  + `Graphe.getNbComposanteConexes()`
  
## Question 4 : 

Le nombre de mots sans voisin est déterminé grâce à :
  + `Graphe.getNbMothSansVoisin()`
  
## Question 5 : 
 
 Le nombre de composantes connexes de taille 2 est déterminé grâce à :
  + `getNbComposantConnexeTaille2()`
  
## Question 6 :
+ Le degré maximal du graphe est calculé grâce à `SommetMot SommetDedegreMax()` qui renvoie le sommet ayant le plus grand degré.
 Nous pouvons ensuite récupérer son degré en récupérant la taille de la liste contenant les relations de ce dernier.
+ Pour déterminer le nombre de sommets avec k voisins, on utilise `SommetsAvecKvoisins(int k)` dans une boucle, avec une variable
allant de i à k = nMax
 
## Question 7 :
 Le diamètre du graphe est récupéré grâce à la fonction `Graphe.getDiametre()` et `getPlusLongChemin()`

## Bonus - liste d'adjacence
 Nous avons affiché des exemples de listes d'adjacence dans des fichiers .txt dans le répertoire `./Exmple de liste d'adjacence`
