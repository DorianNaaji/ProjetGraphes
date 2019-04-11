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
        int numero = 0;
        // Question 1 : Chargement des mots et construction des graphes
        loadGraphes();
//        _graphes.get(1).initializeRelation();
//        List<SommetMot> list = _graphes.get(0).getNbMothSansVoisin();
//        System.out.println("le nombre de composante connexe : " + _graphes.get(1).getNbComposanteConexes());
//        // Question 2 : Nombre de sommets et nombre d'arêtes de chaque graphe pour chaque ensemble de mots
//        getNbSommets_NbAretes_Graphes();
        _graphes.get(numero).initializeRelation();
        //_graphes.get(0).display();
        // question 6
        System.out.println(_graphes.get(numero).SommetDedegreMax().getText());
        System.out.println(_graphes.get(numero).SommetDedegreMax().getRelations().size());
        // Question 2 : Nombre de sommets et nombre d'arêtes de chaque graphe 
        // pour chaque ensemble de mots
        getNbSommets_NbAretes_Graphes(numero);
        sommetsAvecKvoisins(numero);
        System.out.println("le diametre du graphe est: " + _graphes.get(numero).getDiametre());
        System.out.println(_graphes.get(numero).getNbComposanteConexes());
        System.out.println(_graphes.get(numero).getNbComposantConnexeTaille2());
    }
    

    /**
     * Question 6
     */
    private static void sommetsAvecKvoisins(int indiceSommet)
    {
        if(indiceOk(indiceSommet))
        {
            int nMax = _graphes.get(indiceSommet).SommetDedegreMax().getRelations().size();
            System.out.println("Le degré maximal du graphe est : " +  nMax);
            for(int i = 1; i <= nMax; i ++)
            {
                int nbSommetsAvecKvoisins = _graphes.get(indiceSommet).sommetsAvecKvoisins(i).size();
                System.out.println("Le nombre de sommets avec k = " + i + " voisins est : " + nbSommetsAvecKvoisins);
            }
        }
      
    }
    
    /**
     * Cette méthode permet de créer tous les graphes contenant des mots de taille i.
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
     * QUESTION 2
     * Affichage de la Q2 (pour le indiceSommet ième graphe)
     */
    private static void getNbSommets_NbAretes_Graphes(int indiceSommet)
    {
        if(indiceOk(indiceSommet))
        {
            System.out.println("Le nombre de sommets du " + indiceSommet + "ème graphe est " + _graphes.get(indiceSommet).getNbSommets());
            System.out.println("Le nombre d'arêtes du " + indiceSommet + "ème graphe est " + _graphes.get(indiceSommet).getNbAretes());
        }
    }
    
    private static boolean indiceOk(int indice)
    {
        return indice < 15 && indice >= 0;
    }
}
