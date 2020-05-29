/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import db.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 */
public class JuegoBingo {

    public static void main(String[] args) {
        //Place main content here

        BingoDAO bd = new BingoDAO();

        BingoAmericano ba = new BingoAmericano(new CartonAmericano(), new BomboAmericano(), "");
        
        
        
        

    }
    
    public static void dump(BingoAmericano ba){
        BingoDAO bd = new BingoDAO();
        try {
            bd.insertGame(ba);
        } catch (SQLException ex) {
            Logger.getLogger(JuegoBingo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static BingoAmericano restore(BingoAmericano ba, String serial){
        BingoDAO bd = new BingoDAO();
        try {
            ba = bd.findByPk(serial);
            System.out.println("----- RESTAURAR PARTIDA -----");
            System.out.println("Bienvenido de nuevo, " + ba.getName());
            System.out.println(ba.getCarton());
            return ba;
        } catch (Exception ex) {
            System.out.println("Error: No se pudo aplicar el recurso. Error " + ex.getMessage() + ". Se generará una partida nueva");
            return new BingoAmericano(new CartonAmericano(), new BomboAmericano(), "");
        }
    }
}
