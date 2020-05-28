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
                b.setCarton(crearCarton(res.getString("nombre")));
                b.setFecha(res.getDate("fecha").toLocalDate());
                b.setName(res.getString("Persona"));
                return b;
            }

            return null;
        }
    }

    @Override
    public int insertGame(Bingo b) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteGame(Bingo b) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateGame(int pk, Bingo b) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private CartonAmericano crearCarton(String s){
        CartonAmericano c = new CartonAmericano();
        String[] tokens;
        String linea = s;
        tokens = linea.split(",");
        int aum = 0;
        int[][] tmp = new int[3][9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                tmp[i][j] = Integer.parseInt(tokens[aum]);
                aum++;
            }
        }
        c.setMatriz(tmp);
        return c;
    }
}
