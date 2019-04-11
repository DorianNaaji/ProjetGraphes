/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetgraphes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Dorian
 */
public class Graphe
{
    
    private ArrayList<SommetMot> _sommets = new ArrayList<SommetMot>();
    
    /**
     * see : 
     * https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
     * QUESTION 1 : permet de charger tous les mots d'un fichier et de les ajouter à la liste de sommet de notre graphe de mots de taille i
     */
    public void load(String filename)
    {
        // le mot qui va être lu
        String mot = null;
        try
        {
            FileReader reader = new FileReader(filename);
            BufferedReader buffer = new BufferedReader(reader);
            // tant qu'il y a des mots dans le fichier
            while( (mot = buffer.readLine()) != null)
            {
                // on crée un sommet à partir du mot courant du fichier ( de la ligne courante du fichier)
                SommetMot sommet = new SommetMot(mot);
                // on l'ajoute à notre liste de sommets du graphe
                this._sommets.add(sommet);
            }
            buffer.close();
        }
        catch(Exception ex)
        {
            System.out.println("ERROR " + ex);   
        }
    }
    
    public void initializeRelation(){
        int i = 0;
        for(SommetMot mot : _sommets){
            i++;
            for(int j = i; j < _sommets.size(); j++){
                if (mot.compareTo(_sommets.get(j), 1))
                    mot.makeRelation(_sommets.get(j));
            }
        }
    }
    
    /**
     * 
     * @return Retourne le nombre de sommet d'un graphe (Q2)
     */
    public int getNbSommets()
    {
        return this._sommets.size();
    }
    
    /**
     * 
     * @return Retourne le nombre d'arêtes d'un graphe (Q2)
     */
    public int getNbAretes()
    {
        return 0;
    }

    @Override
    public String toString() {
        return "Graphe{" + 
                System.getProperty("line.separator") + 
                "_sommets=" + _sommets + 
                System.getProperty("line.separator") + '}';
    }
    
    
}   
    
    
