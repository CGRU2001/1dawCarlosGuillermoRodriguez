/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public abstract class Bombo {
    private List<Integer> listaBolas;

    public Bombo(int numeroBolas) {
        listaBolas = new ArrayList<>();
        
        for (int i = 0; i < numeroBolas; i++) {
            listaBolas.add((i + 1));
        }
        
    }
    
    
    
}
