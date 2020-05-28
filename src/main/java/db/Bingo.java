/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import bingo.*;
import java.sql.SQLException;

/**
 *
 * @author carlos
 */
public interface Bingo {

    BingoAmericano findByPk(String pk) throws SQLException;

    int insertGame(Bingo b) throws SQLException;

    int deleteGame (Bingo b) throws SQLException;
    
    boolean updateGame(int pk, Bingo b) throws SQLException;
}
