/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banco;

/**
 *
 * @author willian
 */
public class ContaEspecial extends Conta{

    public ContaEspecial(int numConta, double saldo) {
        super(numConta, saldo);
    }

    public ContaEspecial(int numConta) {
        super(numConta);
    }
    
    @Override
    public void saque(double saque){
        setSaldo(getSaldo() - 0.10 - saque);
    }
    
    @Override
    public void atualiza(double taxa){
        double saldo = getSaldo();
        setSaldo(saldo + (taxa*2*saldo));
    }
}
