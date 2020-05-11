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
public final class BingoEuropeo extends Bingo {
    private CartonEuropeo carton;
    private BomboEuropeo bombo;

    public BingoEuropeo(String name) {
        super(name);
        this.carton = new CartonEuropeo();
        this.bombo = new BomboEuropeo();
    }

    public CartonEuropeo getCarton() {
        return carton;
    }

    public void setCarton(CartonEuropeo carton) {
        this.carton = carton;
    }

    public BomboEuropeo getBombo() {
        return bombo;
    }

    public void setBombo(BomboEuropeo bombo) {
        this.bombo = bombo;
    }

    @Override
    public String toString() {
        return "Estás jugando al bingo europeo. Tu cartón es el siguiente:\n" + carton.toString();
    }
    
    
    
}
