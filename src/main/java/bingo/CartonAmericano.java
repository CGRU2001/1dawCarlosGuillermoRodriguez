/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author carlos
 */
public final class CartonAmericano extends Carton {
    public static final int FILAS = 5;
    public static final int COLUMNAS = 5;
    private final Patron premio;

    public CartonAmericano(Patron p) {
        super(FILAS, COLUMNAS);
        premio = p;
    }

    public Patron getPremio() {
        return premio;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public void generarCarton(){
        Random r = new Random();
        ArrayList<Point> casillas = (ArrayList) premio.getCasillas();
        for (int i = 0; i < super.getMatriz().length; i++) {
            for (int j = 0; j < super.getMatriz()[i].length; j++) {
                super.getMatriz()[i][j] = 0;
            }
        }
        for (int i = 0; i < casillas.size(); i++) {
            super.getMatriz()[(int)casillas.get(i).getX()][(int)casillas.get(i).getY()] = r.nextInt(75);
        }
    }
    public static void main(String[] args) {
        Carton c = new CartonAmericano(Patron.VACIO);
        System.out.println(c);
    }
}
