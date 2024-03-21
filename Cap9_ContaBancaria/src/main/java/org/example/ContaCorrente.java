package org.example;

public class ContaCorrente {
    private int numConta;
    private String nomeTitular;
    private double saldo;
    private final double TAXA = 5;


    public ContaCorrente(int numConta, String nomeTitular) {
        this.numConta=numConta;
        this.nomeTitular=nomeTitular;
    }

    public ContaCorrente(int numConta, String nomeTitular, double saldoInicial) {
        this.numConta=numConta;
        this.nomeTitular=nomeTitular;
        depositar(saldoInicial);
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


