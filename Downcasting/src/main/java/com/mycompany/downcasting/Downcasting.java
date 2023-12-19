/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.downcasting;

/**
 *
 * @author willian
 */
public class Downcasting {

    public static void main(String[] args) {
        Classe1[] x = {new Classe1(), new Classe2()};
        
        for (int i = 0; i < x.length; i++) {
            x[i].metodo1();
            x[i].metodo2();
            
            if (x[i] instanceof Classe2){
            Classe2 objClasse2 = (Classe2) x[i];
            objClasse2.metodo3();
        }
        }
        
        
    }
}
