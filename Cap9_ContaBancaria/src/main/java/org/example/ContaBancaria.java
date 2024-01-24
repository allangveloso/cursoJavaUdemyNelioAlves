package org.example;

import java.util.Scanner;

public class ContaBancaria {

    static String nomeTitular;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o nome do titular: ");
        nomeTitular = sc.next();

        System.out.print("Informe o número da conta: ");
        ContaCorrente cc = new ContaCorrente();
        cc.numConta = sc.nextInt();
//        System.out.print("Deseja realizar um depósito inicial s/n? : ");
//        if (sc.next().charAt(0) == 's'){
            System.out.print("Informe um valor para o depósito: ");
            cc.saldo = sc.nextDouble();
//        }
       exibirDadosContaCorrente(nomeTitular,cc.numConta,cc.saldo);


        System.out.println("Informe valor a depositar");
        cc.depositar(sc.nextDouble());

        exibirDadosContaCorrente(nomeTitular,cc.numConta,cc.saldo);

        System.out.println("Informe valor a sacar");
        cc.sacar(sc.nextDouble());

        exibirDadosContaCorrente(nomeTitular,cc.numConta,cc.saldo);

//        System.out.println("Saldo da conta corrente: saldo");
//
//        System.out.println("Informe novo valor a sacar");
//        System.out.println("Saldo da conta corrente: saldo");

    }

    public static void exibirDadosContaCorrente(String nomeTitular, int numConta, double saldo){
        System.out.println("---------------------------------------------------------");
            System.out.printf("Dados da conta corrente: %nConta: " +
                    "%d%nNome do Titular: " +
                    "%s%nSaldo: %.2f%n",
        numConta, nomeTitular, saldo);
        System.out.println("--------------------------------------------------------");
    }
}
