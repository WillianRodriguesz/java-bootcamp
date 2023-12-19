/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.banco;

/**
 *
 * @author willian
 */
public class Banco {

    public static void main(String[] args) {
        Conta c1 = new Conta(10, 0.0);
        Conta c2 = new Conta(10, 5.5);
        System.out.println(c1.equals(c2));
        
        ContaEspecial especial = new ContaEspecial(5, 50);
        especial.saque(10);
        System.out.println(especial.getSaldo());
     
        try {
            c1.deposito(-50);
        } catch (ValorInvalidoException e) {
            System.out.println("Erro ao depositar: " + e.getMessage());
        }
    
    
    
    }
    
    
}
