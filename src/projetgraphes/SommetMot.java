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
    private String _mot;
    private List<SommetMot> _relations = new ArrayList<SommetMot>();

    public String getMot() {
        return _mot;
    }

    public void setMot(String mot) {
        this._mot = mot;
    }

    public List<SommetMot> getRelations() {
        return _relations;
    }

    public void setRelations(List<SommetMot> relations) {
        this._relations = relations;
    }
    
    public SommetMot(String mot){
        _mot = mot;   
    }
    
    // ajoute un mot dans la liste de façons unilatéral
    public void addRelation(SommetMot mot){
        if(mot == null)
            throw new IllegalArgumentException();
        if(!_relations.contains(mot)){
            _relations.add(mot);
        }
            
    }
    
    // retire un mot de la liste de façons unilatéral
    public void removeRelation(SommetMot mot){
        if(mot == null)
            throw new IllegalArgumentException();
        if(_relations.contains(mot)){
            _relations.remove(mot);
        }
    }
    
    // créer une relation entre deux sommet
    public void makeRelation(SommetMot mot){
        if(mot == null)
            throw new IllegalArgumentException();
        if(!_relations.contains(mot)){
            _relations.add(mot);
        }
        if(!mot._relations.contains(mot)){
            mot._relations.add(mot);
        }
    } 
    
    // supprime une relation entre deux sommet
    public void deleteRelation(SommetMot mot){
        if(mot == null)
            throw new IllegalArgumentException();
        if(_relations.contains(mot)){
            _relations.remove(mot);
        }
        if(mot._relations.contains(mot)){
            mot._relations.remove(mot);
        }
    }
    
    
}
