/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import db.*;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 */
public class JuegoBingo {

    public static void main(String[] args) {
        //Place main content here
        BingoAmericano ba = new BingoAmericano(new CartonAmericano(), new BomboAmericano(), "");
        Scanner s = new Scanner(System.in);
        String nombre, lectura, serial, val;
        int bola;
        System.out.println("Bienvenido al bingo. ");
        System.out.println("-- El BINGO EUROPEO ESTÁ DESHABILITADO DE MANERA TEMPORAL, POR TANTO, SÓLO SE PODRÁ JUGAR BINGO AMERICANO --");

        ba.getBombo().llenarBolas();
        ba.getCarton().generarCarton();
        do {
            System.out.print("¿Quieres cargar una nueva partida?: ");
            lectura = s.nextLine();
            if (lectura.equalsIgnoreCase("si")) {
                System.out.print("Introduce el número de serie de la partida: ");
                serial = s.nextLine();
                ba = restore(ba, serial);
            } else if (lectura.equalsIgnoreCase("no")) {

                System.out.println("Creando nueva partida...");
                System.out.print("Introduce tu nombre: ");
                nombre = s.nextLine();
                ba.setName(nombre);
            }
        } while (!(lectura.equalsIgnoreCase("Si") || lectura.equalsIgnoreCase("No")));
        if (ba.getName().equals(null) || ba.getName().equals("")) {
            System.out.println("Puesto que no pudimos cargar el nombre anteriormente, introduce uno nuevo ahora");
            System.out.print("Introduce tu nombre: ");
            nombre = s.nextLine();
            ba.setName(nombre);
        }

        do {
            System.out.println("Pulsa intro para una nueva bola, o bien, pulsa s para guardar partida: ");
            val = s.nextLine();
            if (val.equalsIgnoreCase("s")) {
                dump(ba);
            } else {
                
                bola = ba.getBombo().sacarBola();
                System.out.println("Ha salido la bola " + bola);
                ba.getCarton().tachar(bola);
                
                System.out.println(ba.getCarton());
                if (ba.getCarton().cantarBingo()) {
                    System.out.println("YOU WIN!");
                    break;
                }
            }
        } while (!ba.getBombo().getListaBolas().isEmpty());

    }

    public static void dump(BingoAmericano ba) {
        BingoDAO bd = new BingoDAO();
        try {
            bd.insertGame(ba);
            System.out.println("El código de tu partida es: " + ba.getId() + ". No lo pierdas, puesto que puedes necesitarlo para restaurar tu partida más tarde");
            System.exit(0);
        } catch (SQLException ex) {
            Logger.getLogger(JuegoBingo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static BingoAmericano restore(BingoAmericano ba, String serial) {
        BingoDAO bd = new BingoDAO();
        try {
            ba = bd.findByPk(serial);
            bd.deleteGame(ba);
            System.out.println("----- RESTAURAR PARTIDA -----");
            System.out.println("Bienvenido de nuevo, " + ba.getName());
            System.out.println("Tu cartón era: ");
            System.out.println(ba.getCarton());
            bd.deleteGame(ba);
            
            return ba;
        } catch (Exception ex) {
            System.out.println("Error: No se pudo aplicar el recurso. Error " + ex.getMessage() + ". Se generará una partida nueva.");
            System.exit(0);
            return null;
        }
    }
}
