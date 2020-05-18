/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.Collections;

/**
 *
 * @author carlos
 */
public final class BomboAmericano extends Bombo {
    public static final int CANTIDADBOLAS = 75;

    public BomboAmericano() {
        super();
    }

    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public void llenarBolas() {
        for (int i = 0; i < CANTIDADBOLAS; i++) {
            super.getListaBolas().add(i + 1);
        }
        Collections.shuffle(super.getListaBolas());
    }
    public static void main(String[] args) {
        Bombo b = new BomboAmericano();
        b.llenarBolas();
        System.out.println(b);
        System.out.println(b.sacarBola());
        System.out.println(b);
    }
}
