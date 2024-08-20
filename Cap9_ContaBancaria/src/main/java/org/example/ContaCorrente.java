package org.example;

import java.util.Random;

public class ContaCorrente {
    Random random = new Random();
    private int numConta;
    private String nomeTitular;
    private double saldo;
    private final double TAXA = 5;

    public ContaCorrente(String nomeTitular) {
        this.numConta=random.nextInt(10);
        this.nomeTitular=nomeTitular;
    }

    public ContaCorrente(String nomeTitular, double saldoInicial) {
        this.numConta=random.nextInt(10);
        this.nomeTitular=nomeTitular;
        depositar(saldoInicial);
    }
    public int getNumConta() {
        return numConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTAXA() {
        return TAXA;
    }

    public void depositar(double valor) {

        this.saldo += valor;
    }

    public void sacar(double valor) {

        this.saldo -= (valor + TAXA);
    }

    public String toString() {
        return
                "\n"
                        +"================================================="
                        +"\n"
                        +"Dados da conta corrente "
                        +"\n"
                        +"Número:                 "
                        +numConta
                        +"\n"
                        +"Nome do Titular:        "
                        +nomeTitular
                        +"\n"
                        +"Saldo:                  "
                        + String.format("%.2f", saldo)
                        +"\n"
                        +"================================================="
                        +"\n";
    }
}


