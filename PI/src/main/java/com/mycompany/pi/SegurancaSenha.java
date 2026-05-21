/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pi;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author danda
 */
public class SegurancaSenha {
    public static String gerarHash(String senha){
        return BCrypt.hashpw(senha, BCrypt.gensalt());
    }
    public static boolean verificarSenha(String senhaDigitada, String hashSalvo){
        return BCrypt.checkpw(senhaDigitada, hashSalvo);
    }
}
