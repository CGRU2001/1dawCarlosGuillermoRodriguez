/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.Collection;
import java.util.Collections;


/**
 *
 * @author carlos
 */
public final class BomboEuropeo extends Bombo {
    public static final int BOLAS = 90;

    public BomboEuropeo() {
        super();
        
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void llenarBolas() {
        for (int i = 0; i < BOLAS; i++) {
            super.getListaBolas().add(i + 1);
        }
        Collections.shuffle(super.getListaBolas());
    }
}
