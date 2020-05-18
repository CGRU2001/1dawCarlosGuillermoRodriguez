/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author carlos
 */
public abstract class Bombo {
    private List<Integer> listaBolas;

    public Bombo() {
        listaBolas = new ArrayList<>();
    }
    
    public abstract void llenarBolas();
    
    public int sacarBola(){
        return listaBolas.remove(0);
    }
    
    public int numBolasDentro(){
        return listaBolas.size();
    }
    public boolean vacio(){
        return listaBolas.isEmpty();
    }
    
    //Getters and setters

    public List<Integer> getListaBolas() {
        return listaBolas;
    }
    

//    public void setListaBolas(List<Integer> listaBolas) {
//        this.listaBolas = listaBolas;
//    }

    @Override
    public String toString() {
        return listaBolas.toString();
    }
    
    
    
}
