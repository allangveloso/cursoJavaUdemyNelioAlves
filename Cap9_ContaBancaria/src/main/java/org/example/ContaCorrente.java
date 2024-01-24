package org.example;

public class ContaCorrente {
    public int numConta;
    public double saldo;
    //    public String nomeTitular;
    public final double TAXA = 5;

    public double depositar(double valor) {
        this.saldo += valor;
        return saldo;
    }

    public double sacar(double valor) {
        this.saldo -= (valor + TAXA);
        return saldo;
    }
}
