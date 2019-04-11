/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetgraphes;

import java.util.ArrayList;


/**
 *
 * @author Dorian
 */
public class ProjetGraphes
{

    private static ArrayList<Graphe> _graphes = new ArrayList<Graphe>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // pour avoir les réponses aux questions sur un graphe, il suffit de donné son indice dans numéro et d'appeler la méthode affichagePourUnGraphe :
        // Pour le 1er graphe (mots de taille 4) : On donne pour indice 0
        // (...)
        // Pour le 15 ème graphe, on donne pour indice 14 (mot de taille 18)
        int numero = 0;
        affichagePourUnGraphe(numero);
    }
    
    
    /**
     * Cette méthode permet d'afficher toutes les informations demandées de l'énoncé pour un graphe donné (sachant que l'indice du graphe va de 0 à 14, donc 15 grapges pour 15 fichiers)
     * @param indiceGraphe 
     */
    private static void affichagePourUnGraphe(int indiceGraphe)
    {
        if(indiceOk(indiceGraphe))
        {
            loadGraphes();
            _graphes.get(indiceGraphe).initializeRelation();
            int ième = indiceGraphe+1;
            System.out.println("--- Question 2 --- ");
            System.out.println("Le nombre de sommets du " + ième + "ème graphe est " + _graphes.get(indiceGraphe).getNbSommets());
            System.out.println("Le nombre d'arêtes du " + ième + "ème graphe est " + _graphes.get(indiceGraphe).getNbAretes());
            System.out.println();
            
            System.out.println("--- Question 3 --- ");
            System.out.println("Le nombre de composantes connexes du " + ième + "ème graphe est " + _graphes.get(indiceGraphe).getNbComposanteConexes());
            System.out.println();
            
            System.out.println("--- Question 4 --- ");
            System.out.println("Le nombre de mots sans voisin(s) du " + ième + "ème graphe est " + _graphes.get(indiceGraphe).getNbMothSansVoisin().size());
            System.out.println();
            
            System.out.println("--- Question 5 --- ");
            System.out.println("Le nombre de composantes connexes constituées uniquement de deux mots du " + ième + "ème graphe est " + _graphes.get(indiceGraphe).getNbComposantConnexeTaille2());
            System.out.println();
            
            System.out.println("--- Question 7 --- ");
            System.out.println("Le diamètre du " + ième + "ème graphe est " + _graphes.get(indiceGraphe).getDiametre());
            System.out.println();
            
            System.out.println("--- Question 6 --- ");
            int nMax = _graphes.get(indiceGraphe).SommetDedegreMax().getRelations().size();
            System.out.println("Le degré maximal du graphe est : " +  nMax);
            for(int i = 1; i <= nMax; i ++)
            {
                int nbSommetsAvecKvoisins = _graphes.get(indiceGraphe).sommetsAvecKvoisins(i).size();
                System.out.println("Le nombre de sommets avec k = " + i + " voisins du " + ième + "ème graphe est : " + nbSommetsAvecKvoisins);
            }
            System.out.println();
        }
    }
   
    
    /**
     * Cette méthode permet de créer tous les sommets des graphes contenant des mots de taille i, à partir des fichiers donnés.
     * On crée dynamiquement un nom de fichier txt puis on charge l'ensemble de ses mots.
     */
    private static void loadGraphes()
    {
        /** Question 1 : chargement des graphes */
        for(int i = 4; i < 19; i++)
        {
            Graphe g = new Graphe();
            // nom de fichier dynamique
            String filename = "mots/mots";
            if(i < 10)
            {
               filename += "0";
               filename += i;
            }
            else
            {
                filename += i;
            }
            filename +="lettres.txt";
            // on charge les mots du graphes
            g.load(filename);
            // on l'ajoute à notre liste de graphes
            _graphes.add(g);
         }
    }
   
    /**
     * Confirme qu'un indice donné dans le main est entre 0 et 14
     * @param indice
     * @return 
     */
    private static boolean indiceOk(int indice)
    {
        return indice < 15 && indice >= 0;
    }
}
