/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author carlos
 */
public abstract class Bingo {
    private String id;
    private LocalDate fecha;
    private String name;

    public Bingo(String id, LocalDate fecha, String name) {
        this.id = id;
        this.fecha = fecha;
        this.name = name;
    }
    
    public Bingo(String name){
        //Only insert player name
        Random r = new Random();
        this.name = name;
        this.fecha = LocalDate.now();
        this.id = Integer.toString(r.nextInt(999999) + (char)(r.nextInt(93) + 65));
    }
     // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ("el jugador " + this.name + " en la partida con ID " + this.id + " el día " + this.fecha);
    }
    
    
    
}
