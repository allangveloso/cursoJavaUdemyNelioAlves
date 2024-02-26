package org.example;

import java.util.Scanner;

public class ContaBancaria {
//foi substituída por classe Programm


    private static String nomeTitular;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ContaCorrente cc = new ContaCorrente();

        int op=0;

        while (op!= 4) {
            System.out.println("--------------------Menu de opções--------------------");
            System.out.println("0-Cadastrar conta corrente");
            System.out.println("1-Alterar o nome do titular");
            System.out.println("2-Realizar Depósito");
            System.out.println("3-Realizar Saque");
            System.out.println("4-Sair");
            System.out.println("------------------------------------------------------");
            op = sc.nextInt();

            switch (op) {
                case 0:
                    System.out.print("Informe um nome para o titular: ");
                    nomeTitular = sc.next();

                    System.out.print("Informe o número da conta: ");
                    cc.numConta = sc.nextInt();

                    System.out.print("Deseja realizar um depósito inicial? s/n: ");
                    char dep;
                    dep = sc.next().charAt(0);
                    if(dep == 's'){
                        System.out.println("Informe um valor para o depósito: ");
                        cc.depositar(sc.nextDouble());
                    }

                    exibirDadosContaCorrente(cc.numConta, cc.getSaldo());
                    System.out.println();
                    break;
                case 1:
                    System.out.print("Informe um novo nome para o titular: ");
                    nomeTitular = sc.next();
                    exibirDadosContaCorrente(cc.numConta, cc.getSaldo());
                    break;
                case 2:
                    System.out.print("Informe um valor para o depósito: ");
                    cc.depositar(sc.nextDouble());
                    exibirDadosContaCorrente(cc.numConta, cc.getSaldo());
                    break;
                case 3:
                    System.out.print("Informe valor a sacar: ");
                    cc.sacar(sc.nextDouble());
                    exibirDadosContaCorrente(cc.numConta, cc.getSaldo());
                    break;
                case 4:
                    System.out.print("Finalizando o programa!");
                    break;
                default:
                    System.out.print("Valor inválido.");
                    throw new IllegalStateException("Unexpected value: " + sc.nextInt());
            }
        }
    }

    public static void exibirDadosContaCorrente(int numConta, double saldo) {
        System.out.println("=================================================================");
        System.out.printf("Dados da conta corrente %n" +
                        "Conta:                  " +
                        "%d%nNome do Titular:        " +
                        "%s%nSaldo:                  %.2f%n",
                numConta, nomeTitular, saldo);
        System.out.println("=================================================================");
        System.out.println();
    }

}

