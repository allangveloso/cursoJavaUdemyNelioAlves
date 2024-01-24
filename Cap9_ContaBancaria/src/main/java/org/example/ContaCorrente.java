package org.example;

public class ContaCorrente {
    public int numConta;
    public double saldo;
    //    public String nomeTitular;
    public final double TAXA = 5;

<<<<<<< HEAD
    public void depositar(double valor) {
        this.saldo += valor;
//        return saldo;
    }

    public void  sacar(double valor) {
        this.saldo -= (valor + TAXA);
//        return saldo;
=======
    public double depositar(double valor) {
        this.saldo += valor;
        return saldo;
    }

    public double sacar(double valor) {
        this.saldo -= (valor + TAXA);
        return saldo;
>>>>>>> fcf2863d010935a2f2c44c1cd03b056f8ae997a8
    }
}
