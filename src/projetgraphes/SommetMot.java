/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetgraphes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dorian
 */
public class SommetMot
{
    private String _text;
    private List<SommetMot> _relations = new ArrayList<SommetMot>();

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
    }
    
    /*
        ajoute un mot dans la liste de façons unilatéral
    */
    public void addRelation(SommetMot mot){
        if(mot == null)
            throw new IllegalArgumentException();
        if(!_relations.contains(mot)){
            _relations.add(mot);
        }
            
    }
    
    
    /*
        retire un mot de la liste de façons unilatéral
    */
    public void removeRelation(SommetMot mot){
        if(mot == null)
            throw new IllegalArgumentException();
        if(_relations.contains(mot)){
            _relations.remove(mot);
        }
    }
    
    /*
        créer une relation entre deux sommet
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
    
    /*
        supprime une relation entre deux sommet
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

    @Override
    public String toString() {
        return "SommetMot{" + "mot=" + _text + ", relations=" + _relations + '}';
    }
    
    /**
     * Compare si le mot donné est différent de celui comparé
     * à n lettre près
     * @param mot : le mot à comparé 
     * @param change : le nombre de changement minimum et maximum
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
