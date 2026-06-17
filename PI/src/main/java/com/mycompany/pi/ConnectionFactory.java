/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author danda
 */
public class ConnectionFactory {
    String usuario = "root";
    String senha = "Tataneto2705";
    String host = "localhost";
    String porta = "3306";
    String bd = "jogo_quimica_etec";
    
    public Connection obtemConexao(){
        try{
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://" + host + ":" + porta + "/" + bd,usuario,senha
            );
            return c;
        }catch(SQLException e){
            return null;
        }
    }
    
    
}



