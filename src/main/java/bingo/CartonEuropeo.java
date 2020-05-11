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
public final class CartonEuropeo extends Carton{
    public static final int FILAS = 3;
    public static final int COLUMNAS  = 9;

    public CartonEuropeo(int filas, int columnas) {
        super(filas, columnas);
    }

    //We don't need getters, because we have final attributes
    
    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
}
