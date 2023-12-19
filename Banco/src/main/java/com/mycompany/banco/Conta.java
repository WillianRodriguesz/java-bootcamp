/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banco;

/**
 *
 * @author willian
 */
public class Conta {
    private int numConta;
    private double saldo;
    
    public Conta (int numConta, double saldo){
        this.numConta = numConta;
        this.saldo = saldo;
    }
    
    public Conta (int numConta){
        this.numConta = numConta;
        this.saldo = 0;
    }
    
    public boolean equals(Conta obj){
        if (this.numConta == obj.numConta){
            return true;
        }
        return false;
    }
    
    public void deposito(double deposito) throws ValorInvalidoException {
        if (deposito < 0) {
            throw new ValorInvalidoException("Depósito não pode ser negativo");
        } else {
            this.saldo = this.saldo + deposito;
        }
    }

    
    public void saque(double saque){
        this.saldo = saque;
    }
    
    public void atualiza(double taxa){
        this.saldo = this.saldo - (this.saldo*taxa);
    }
    
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumConta() {
        String msg = "Numero da conta: " + Integer.toString(numConta);
        return msg;
    }

    public double getSaldo() {
        return saldo;
    }
    
    
    
    
}
