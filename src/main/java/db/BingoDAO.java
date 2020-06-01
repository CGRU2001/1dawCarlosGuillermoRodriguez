/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import bingo.BingoAmericano;
import bingo.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author carlos
 */
public class BingoDAO implements Bingo{
    private Connection con = null;
    public BingoDAO(){
        con = Conexion.getInstance();
    }

    @Override
    public BingoAmericano findByPk(String pk) throws SQLException {
        ResultSet res = null;
        BingoAmericano b = new BingoAmericano(new CartonAmericano(), new BomboAmericano(), "", LocalDate.now(), "");

        String sql = "select * from juegos where pk=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setString(1, pk);

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.next()) {
                // Recogemos los datos de la persona, guardamos en un objeto
                b.setId(res.getString("pk"));
                b.setCarton(crearCarton(res.getString("carton")));
                b.setFecha(res.getDate("fecha").toLocalDate());
                b.setBombo(convertBombo(res.getString("bombo")));
                b.setName(res.getString("Persona"));
                return b;
            }

            return null;
        }
    }

    @Override
    public int insertGame(BingoAmericano b) throws SQLException {
         int numFilas = 0;
        String sql = "insert into juegos values (?,?,?,?,?)";

        
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setString(1, b.getId());
                prest.setDate(2, Date.valueOf(b.getFecha()));
                prest.setString(3, convertCarton(b.getCarton()));
                prest.setString(4, b.getBombo().toString());
                prest.setString(5, b.getName());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        
    }

    @Override
    public void deleteGame(BingoAmericano b) throws SQLException {
        String sql = "delete from juegos where pk=?";
        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setString(1, b.getId());
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            prest.executeQuery();
        }
    }

    @Override
    public boolean updateGame(int pk, BingoAmericano b) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private CartonAmericano crearCarton(String s){
        CartonAmericano c = new CartonAmericano();
        String[] tokens;
        String linea = s;
        tokens = linea.split(",");
        int aum = 0;
        int[][] tmp = c.getMatriz();
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                tmp[i][j] = Integer.parseInt(tokens[aum]);
                aum++;
            }
        }
        c.setMatriz(tmp);
        return c;
    }
    private String convertCarton(CartonAmericano c){
        String finale = "";
        int cont = 0;
        for (int i = 0; i < c.getMatriz().length; i++) {
            for (int j = 0; j < c.getMatriz()[i].length; j++) {
                finale += c.getMatriz()[i][j];
                cont++;
                if(cont != 25){
                    finale += ',';
                    
                }else{
                    break;
                }
            }
        }
        
        return finale;
    }
    private BomboAmericano convertBombo(String b){
        BomboAmericano ba = new BomboAmericano();
        String[] tokens;
        String linea = b;
        tokens = linea.split(",");
        for (int i = 0; i < tokens.length; i++) {
            ba.getListaBolas().add(Integer.parseInt(tokens[i]));
        }
        return ba;   
    }
}
