/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author carlos
 */
public final class CartonAmericano extends Carton {
    public static final int FILAS = 5;
    public static final int COLUMNAS = 5;
    private final Patron premio;

    public CartonAmericano() {
        super(FILAS, COLUMNAS);
        premio = genPatron();
        generarCarton();
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
    
    private Patron genPatron(){
        Random aleatorio = new Random();

        switch (aleatorio.nextInt(5)) {
            case 0:
                return Patron.VACIO;
                
            case 1:
                return Patron.FORMA_X;
               
            case 2:
                return Patron.FORMA_F;
                
            case 3:
                return Patron.LLENO;
                
            default:
                return Patron.UNO;
        }
    }
    
}
