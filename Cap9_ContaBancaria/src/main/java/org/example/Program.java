package org.example;

import java.util.Scanner;

public class Program {

    private static String nomeTitular;

    private static int numConta;
    static double vlrDeposito;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ContaCorrente cc=null;

        int op=1;

        while (op!= 0) {
            System.out.println("--------------------Menu de opções--------------------");
            System.out.println("1-Cadastrar conta corrente");
            System.out.println("2-Alterar o nome do titular");
            System.out.println("3-Realizar Depósito");
            System.out.println("4-Realizar Saque");
            System.out.println("0-Sair");
            System.out.println("------------------------------------------------------");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Informe o número da conta: ");
                    numConta = sc.nextInt();

                    System.out.print("Informe um nome para o titular: ");
                    nomeTitular = sc.next();

                    System.out.print("Deseja realizar um depósito inicial? s/n: ");
                    char dep = sc.next().charAt(0);
                    if(dep == 's'){
                        System.out.println("Informe um valor para o depósito: ");
                        vlrDeposito = sc.nextDouble();
                        cc = new ContaCorrente(numConta, nomeTitular,vlrDeposito);
                    }
                    else
                        cc = new ContaCorrente(numConta, nomeTitular);
                    System.out.println(cc);
                    break;
                case 2:
                    System.out.print("Informe um novo nome para o titular: ");
                    nomeTitular = sc.next();
                    cc = new ContaCorrente(numConta, nomeTitular,vlrDeposito);
                    System.out.println(cc);
                    break;
                case 3:
                    System.out.print("Informe um valor para o depósito: ");
                    cc.depositar(sc.nextDouble());
                    System.out.println(cc);
                    break;
                case 4:
                    System.out.print("Informe valor a sacar: ");
                    cc.sacar(sc.nextDouble());
                    System.out.println(cc);
                    break;
                case 0:
                    System.out.print("Finalizando o programa!");
                    break;
                default:
                    System.out.print("Valor inválido.");
                    throw new IllegalStateException("Unexpected value: " + sc.nextInt());
            }
        }
    }
}
