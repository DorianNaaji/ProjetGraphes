package projetgraphes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


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
     * QUESTION 1 : permet de charger tous les mots d'un fichier et de 
     * les ajouter à la liste de sommet de notre graphe de mots de taille i
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
                // on crée un sommet à partir du mot courant du fichier 
                // ( de la ligne courante du fichier)
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
    
    /**
     * Initialise toutes les relations entre tout les sommets du graphe
     */
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
     * Obtient le nombre de sommet du graphe
     * @return Retourne le nombre de sommet d'un graphe (Q2)
     */
    public int getNbSommets(){
        return this._sommets.size();
    }
    
    /**
     * Obtient le nombre d'arêtes du graphe
     * @return Retourne le nombre d'arêtes d'un graphe (Q2)
     */
    public int getNbAretes()
    {
        int nbAretes = 0;
        for(int i = 0; i < this._sommets.size(); i++)
        {
            nbAretes += this._sommets.get(i).getRelations().size();
        }
        return nbAretes/2;
    }
    
    /**
     * Obtient le sommet de degré max du  graphe
     * @return le sommet de degréMax
     */
    public SommetMot SommetDedegreMax()
    {
        int nMax = 0;
        SommetMot sommetDegreMax = null;
        for(int i = 0; i < this._sommets.size(); i++)
        {
            int degreCourant = this._sommets.get(i).getRelations().size();
           // nMax = (degreCourant > nMax) ? degreCourant : nMax;
           if(degreCourant > nMax)
           {
               nMax = degreCourant;
               sommetDegreMax = this._sommets.get(i);
           }
        }
        return sommetDegreMax;
    }
    
    /**
     * Obtient le nombre de sommet avec k voisins
     * @param k le nombre de voisin à avoir
     * @return retourne le nombre de sommet
     */
    public ArrayList<SommetMot> sommetsAvecKvoisins(int k)
    {
        ArrayList<SommetMot> sommetsAvecKVoisins = new ArrayList<SommetMot>();
        for(int i = 0; i < this._sommets.size(); i++)
        {
            if(this._sommets.get(i).getRelations().size() == k)
            {
                sommetsAvecKVoisins.add(this._sommets.get(i));
            }
        }
        return sommetsAvecKVoisins;
    }
    
    /**
     * Obtient les mots sans voisins
     * @return retourne une liste
     */
    public List<SommetMot> getNbMothSansVoisin(){
        List <SommetMot> list = new ArrayList<>();
        for (SommetMot mot : _sommets) {
            if(mot.getRelations().isEmpty())
                list.add(mot);
        }
        return list;
    }
    
    /**
     * Permet de visiter le graphe en largeur à partir du sommet
     * mot
     * @param mot sommet de départ
     * @return retourne la liste des sommets visités
     */
    public List<SommetMot> visiteLargeur(SommetMot mot){
        List<SommetMot> list = new ArrayList<>();
        list.add(mot);
        for(int i = 0; i < list.size(); i++){
            for(SommetMot voisin : list.get(i).getRelations()){
                if(!voisin.getMarque()){
                    list.add(voisin);
                    voisin.setMarque(true);
                }
            }
        }
        return list;
    }
    
    /**
     * Obtient le nombre de composante connexe du graphe
     * @return retourne le nombre de composante connexe
     */
    public int getNbComposanteConexes(){
        List<SommetMot> list = new ArrayList<>();
        list.addAll(_sommets);
        int i = 0;
        //return visiteLargeur(list.get(0)).size();
        while(!list.isEmpty()){
            list.removeAll(visiteLargeur(list.get(0)));
            i++;
        }
        // remet les marque à zero
        for(SommetMot mot : _sommets)
            mot.setMarque(false);
        return i;
    }
    
    /**
     * Obtient le plus chemin (diect) existant à partir d'un sommet
     * @param mot le sommet de départ
     * @return retourne le taille du plus long chemin
     */
    public int getPlusLongChemin(SommetMot mot){
        List<SommetMot> list = new ArrayList<>();
        list.add(mot);
        mot.setValeur(0);
        int distanceMax = 0;
        for(int i = 0; i < list.size(); i++){
            for(SommetMot voisin : list.get(i).getRelations()){
                if(!voisin.getMarque()){
                    list.add(voisin);
                    voisin.setMarque(true);
                    voisin.setValeur(list.get(i).getValeur() + 1);
                    if(voisin.getValeur() > distanceMax)
                        distanceMax = voisin.getValeur();
                }
            }
        }
        // remet les marque à zero
        for(SommetMot sommet :_sommets){
            sommet.setMarque(false);
            sommet.setValeur(0);
        }
        return distanceMax + 1;
    }
    
    /**
     * Obtient le diamètre du graphe
     * @return retourne le diamètre
     */
    public int getDiametre(){
        int distanceMax = 0;
        int tmp;
        for(SommetMot mot : _sommets){
            tmp = getPlusLongChemin(mot);
            if(tmp > distanceMax) 
                distanceMax = tmp;
        }
        return distanceMax;        
    }
    
    /**
     * Affiche le graphe
     */
    public void display(){
        System.out.println("Graphe{");
        for(SommetMot mot : _sommets){
            mot.display();
        }
        System.out.println("}");             
    }
    
    /**
     * Obtient le nombre de composante composées de deux sommets uniquement
     * @return retourne le nombre
     */
    public int getNbComposantConnexeTaille2(){
        int number = 0;
        for(SommetMot mot : _sommets){
            if(mot.getRelations().size() == 1)
                if(mot.getRelations().get(0).getRelations().size() == 1)
                    number++;                   
        }
        return number / 2;
    }
    
    
}   
    
    
