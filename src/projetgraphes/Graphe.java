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
     * QUESTION 1.
     */
    public void load(String filename)
    {
        String mot = null;

        try
        {
            FileReader reader = new FileReader(filename);
            BufferedReader buffer = new BufferedReader(reader);
            while( (mot = buffer.readLine()) != null)
            {
                SommetMot sommet = new SommetMot(mot);
                this._sommets.add(sommet);
            }

            buffer.close();
        }
        catch(Exception ex)
        {
            System.out.println("ERROR " + ex);   
        }
    }
}   
    
    
