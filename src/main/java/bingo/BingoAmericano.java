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
public final class BingoAmericano {
    private CartonAmericano carton;
    private BomboAmericano bombo;

    public BingoAmericano(CartonAmericano carton, BomboAmericano bombo) {
        this.carton = carton;
        this.bombo = bombo;
    }

    @Override
    public String toString() {
        return "BingoAmericano{" + "carton=" + carton + ", bombo=" + bombo + '}';
    }
    
}
