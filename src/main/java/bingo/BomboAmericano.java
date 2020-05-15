/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

/**
 *
 * @author carlos
 */
public final class BomboAmericano extends Bombo {
    public static final int CANTIDADBOLAS = 75;

    public BomboAmericano(int numeroBolas) {
        super(numeroBolas);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public void llenarBolas(int nuBolas) {
        for (int i = 0; i < nuBolas; i++) {
            super.getListaBolas().add(i);
        }
    }
}
