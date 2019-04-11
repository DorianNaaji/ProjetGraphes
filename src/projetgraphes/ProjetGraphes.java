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
        
        /** Question 1 : chargement des graphes */
        for(int i = 4; i < 19; i++)
        {
            Graphe g = new Graphe();
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
            g.load(filename);
            _graphes.add(g);
         }
    }
}
