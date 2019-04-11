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
        // Question 1 : Chargement des mots et construction des graphes
        loadGraphes();
        _graphes.get(0).initializeRelation();
        System.out.println(_graphes.get(0));
        // Question 2 : Nombre de sommets et nombre d'arêtes de chaque graphe pour chaque ensemble de mots
        getNbSommets_NbAretes_Graphes();
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
     * Affichage de la Q2
     */
    private static void getNbSommets_NbAretes_Graphes()
    {
        for(int i = 0; i < _graphes.size(); i++)
        {
            System.out.println("Le nombre de sommets du " + i + "ème graphe est " + _graphes.get(i).getNbSommets());
            System.out.println("Le nombre d'arêtes du " + i + "ème graphe est " + _graphes.get(i).getNbAretes());
        }
    }
}
