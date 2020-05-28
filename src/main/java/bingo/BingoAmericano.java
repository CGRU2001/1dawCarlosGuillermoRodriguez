/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.time.LocalDate;

/**
 *
 * @author carlos
 */
public final class BingoAmericano extends Bingo{
    private CartonAmericano carton;
    private BomboAmericano bombo;

    public BingoAmericano(CartonAmericano carton, BomboAmericano bombo, String id, LocalDate fecha, String name) {
        super(id, fecha, name);
        this.carton = carton;
        this.bombo = bombo;
    }

    public BingoAmericano(CartonAmericano carton, BomboAmericano bombo, String name) {
        super(name);
        this.carton = carton;
        this.bombo = bombo;
    }

    public CartonAmericano getCarton() {
        return carton;
    }

    public void setCarton(CartonAmericano carton) {
        this.carton = carton;
    }

    public BomboAmericano getBombo() {
        return bombo;
    }

    public void setBombo(BomboAmericano bombo) {
        this.bombo = bombo;
    }

    
    

    @Override
    public String toString() {
        return "BingoAmericano{" + "carton=" + carton + ", bombo=" + bombo + '}';
    }
    
}
