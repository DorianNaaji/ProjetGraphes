package projetgraphes;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant des sommets avec un mots et ou les viosins
 * sont des mots qui varient de 1 lettre.
 * @author Dorian et Thibaut 
 */
public class SommetMot
{
    private String _text;
    private List<SommetMot> _relations = new ArrayList<SommetMot>();
    private boolean _marque;
    private int _valeur;
    
    public int getValeur() {
        return _valeur;
    }

    public void setValeur(int valeur) {
        this._valeur = valeur;
    }
    
    public String getText() {
        return _text;
    }

    public void setText(String text) {
        this._text = text;
    }

    public List<SommetMot> getRelations() {
        return _relations;
    }

    public void setRelations(List<SommetMot> relations) {
        this._relations = relations;
    }
    
    public SommetMot(String text){
        _text = text;  
        _marque = false;
        _valeur = 0;
    }
    
    public boolean getMarque() {
        return _marque;
    }

    public void setMarque(boolean marque) {
        this._marque = marque;
    }
    
    /**
     * ajoute un mot dans la liste de façons unilatéral
     * @param mot 
     */
    public void addRelation(SommetMot mot){
        if(mot == null)
            throw new IllegalArgumentException();
        if(!_relations.contains(mot)){
            _relations.add(mot);
        }
            
    }
    
    
    /**
     * retire un mot de la liste de façons unilatéral
     * @param mot 
     */
    public void removeRelation(SommetMot mot){
        if(mot == null)
            throw new IllegalArgumentException();
        if(_relations.contains(mot)){
            _relations.remove(mot);
        }
    }
    
    /**
     * créer une relation entre deux sommet
     * @param mot le mot
     */
    public void makeRelation(SommetMot mot){
        if(mot == null)
            throw new IllegalArgumentException();
        if(!_relations.contains(mot)){
            _relations.add(mot);
        }
        if(!mot._relations.contains(this)){
            mot._relations.add(this);
        }
    } 
    
    /**
     * supprime une relation entre deux sommet
     * @param mot le mot ou la relation doit etre delete 
     */
    public void deleteRelation(SommetMot mot){
        if(mot == null)
            throw new IllegalArgumentException();
        if(_relations.contains(mot)){
            _relations.remove(mot);
        }
        if(mot._relations.contains(this)){
            mot._relations.remove(this);
        }
    }
    
    /**
     * Affiche le sommet et ses voisins
     */
    public void display(){
        System.out.print("SommetMot{ mot=" + _text + ", relations=");
        for(SommetMot mot : _relations){
            System.out.print(mot._text + " ");
        }
        System.out.println("}");
    }
    
    /**
     * Compare si le mot donné est différent de celui comparé
     * à n lettre près
     * @param mot le mot à comparé 
     * @param change le nombre de changement minimum et maximum
     * @return retourne true si le mot diffère de n lettre précisément,
     * sinon false
     */
    public boolean compareTo(SommetMot mot, int change){
        int diff = 0;
        int i = 0;
        while(i < _text.length() && diff <= change){
            if(_text.charAt(i) != mot._text.charAt(i))
                diff++;
            i++;
        }
        return (change == diff);
    }
    
    
    
    
}
