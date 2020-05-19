/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public enum Patron {
    FORMA_X(equis(), "X"),
    FORMA_F(efe(), "F"),
    LLENO(full(), "Lleno"),
    VACIO(empty(), "Vacío");
    private List<Point> casillas;
    private String descripcion;

    private Patron(List<Point> casillas, String descripcion) {
        this.casillas = casillas;
        this.descripcion = descripcion;
    }

    public List<Point> getCasillas() {
        return casillas;
    }

    public String getDescripcion() {
        return descripcion;
    }
    private static ArrayList<Point> equis(){
        ArrayList<Point> tmp = new ArrayList<>();
        tmp.add(new Point(0, 0));
        tmp.add(new Point(1,1));
        tmp.add(new Point(2,2));
        
        tmp.add(new Point(3, 1));
        tmp.add(new Point(4, 0));
        
        tmp.add(new Point(0, 4));
        tmp.add(new Point(1, 3));
        tmp.add(new Point(3,3));
        tmp.add(new Point(4,4));
        return tmp;
    }
    private static ArrayList<Point> efe(){
        ArrayList<Point> tmp = new ArrayList<>();
        
        tmp.add(new Point(0,0));
        tmp.add(new Point(0,1));
        tmp.add(new Point(0,2));
        tmp.add(new Point(0,3));
        tmp.add(new Point(0,4));
        
        tmp.add(new Point(1,0));
        
        tmp.add(new Point(2,0));
        tmp.add(new Point(2,1));
        tmp.add(new Point(2,2));
        
        tmp.add(new Point(3,0));
        
        tmp.add(new Point(4,0));
        
        return tmp;
    }
    private static ArrayList<Point> full(){
        ArrayList<Point> tmp = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tmp.add(new Point(i,j));
            }
        }
        return tmp;
    }
    private static ArrayList<Point> empty(){
        return new ArrayList<>();
    }
}
