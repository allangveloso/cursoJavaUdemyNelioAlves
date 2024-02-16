package org.example;

public class ContaCorrente {
    public int numConta;
    private double saldo;
    //    public String nomeTitular;
    public final double TAXA = 5;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldoDeposito(double valor) {
        this.saldo += valor;
    }

    public void setSaldoSaque(double valor) {

        this.saldo -= (valor + TAXA);
    }

    public double depositar(double valor) {
        setSaldoDeposito(valor);
        return saldo;
    }

    public double sacar(double valor) {
        setSaldoSaque(valor);
        return saldo;
    }
}
