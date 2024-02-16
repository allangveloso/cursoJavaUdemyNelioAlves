package org.example;

import java.util.Scanner;

public class ContaBancaria {

    static String nomeTitular;

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

                    System.out.print("Informe um valor para depósito inicial (opcional): ");
                    cc.saldo = sc.nextDouble();
                    System.out.println();
                    exibirDadosContaCorrente(nomeTitular, cc.numConta, cc.saldo);

                    break;
                case 1:
                    System.out.print("Informe um novo nome para o titular: ");
                    nomeTitular = sc.next();
                    exibirDadosContaCorrente(nomeTitular, cc.numConta, cc.saldo);
                    break;
                case 2:
                    System.out.print("Informe um valor para o depósito: ");
                    cc.depositar(sc.nextDouble());
                    exibirDadosContaCorrente(nomeTitular, cc.numConta, cc.saldo);
                    break;
                case 3:
                    System.out.print("Informe valor a sacar: ");
                    cc.sacar(sc.nextDouble());
                    exibirDadosContaCorrente(nomeTitular, cc.numConta, cc.saldo);
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

    public static void exibirDadosContaCorrente(String nomeTitular, int numConta, double saldo) {
        System.out.println("=================================================================");
        System.out.printf("Dados da conta corrente: %nConta: " +
                        "%d%nNome do Titular: " +
                        "%s%nSaldo: %.2f%n",
                numConta, nomeTitular, saldo);
        System.out.println("=================================================================");
        System.out.println();
    }


//    static String nomeTitular;
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Informe o nome do titular: ");
//        nomeTitular = sc.next();
//
//        System.out.print("Informe o número da conta: ");
//        ContaCorrente cc = new ContaCorrente();
//        cc.numConta = sc.nextInt();
////        System.out.print("Deseja realizar um depósito inicial s/n? : ");
////        if (sc.next().charAt(0) == 's'){
//            System.out.print("Informe um valor para o depósito: ");
//            cc.saldo = sc.nextDouble();
////        }
//       exibirDadosContaCorrente(nomeTitular,cc.numConta,cc.saldo);
//
//
//        System.out.println("Informe valor a depositar");
//        cc.depositar(sc.nextDouble());
//
//        exibirDadosContaCorrente(nomeTitular,cc.numConta,cc.saldo);
//
//        System.out.println("Informe valor a sacar");
//        cc.sacar(sc.nextDouble());
//
//        exibirDadosContaCorrente(nomeTitular,cc.numConta,cc.saldo);
//
////        System.out.println("Saldo da conta corrente: saldo");
////
////        System.out.println("Informe novo valor a sacar");
////        System.out.println("Saldo da conta corrente: saldo");
//
//    }
//
//    public static void exibirDadosContaCorrente(String nomeTitular, int numConta, double saldo){
//        System.out.println("---------------------------------------------------------");
//            System.out.printf("Dados da conta corrente: %nConta: " +
//                    "%d%nNome do Titular: " +
//                    "%s%nSaldo: %.2f%n",
//        numConta, nomeTitular, saldo);
//        System.out.println("--------------------------------------------------------");
//>>>>>>> fcf2863d010935a2f2c44c1cd03b056f8ae997a8
//    }
}
